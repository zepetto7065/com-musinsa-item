package com.musinsa.product.application.api.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musinsa.product.application.api.item.payload.ItemSaveResponse;
import com.musinsa.product.application.api.item.payload.SaveItemRequest;
import com.musinsa.product.comm.ApiCommonResponse;
import com.musinsa.product.comm.ResponseCode;
import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.domain.Category;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST /api/items - 아이템 생성")
    void createItem() throws Exception {
        SaveItemRequest request = new SaveItemRequest();
        request.setName("신발");
        request.setPrice(BigDecimal.valueOf(10000));
        request.setBrandId(1L);
        request.setCategoryId(2L);

        Item item = Item.builder()
                .id(10L)
                .name("신발")
                .price(BigDecimal.valueOf(10000))
                .brand(Brand.builder().id(1L).name("브랜드A").build())
                .category(Category.builder().id(2L).name("카테고리B").build())
                .build();

        when(itemService.create(any())).thenReturn(item);

        mockMvc.perform(post("/api/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value(ResponseCode.CREATED.getCode()))
                .andExpect(jsonPath("$.data.name").value("신발"));
    }

    @Test
    @DisplayName("PUT /api/items - 아이템 수정")
    void updateItem() throws Exception {
        SaveItemRequest request = new SaveItemRequest();
        request.setItemId(10L);
        request.setName("수정된신발");
        request.setPrice(BigDecimal.valueOf(15000));
        request.setBrandId(1L);
        request.setCategoryId(2L);

        Item item = Item.builder()
                .id(10L)
                .name("수정된신발")
                .price(BigDecimal.valueOf(15000))
                .brand(Brand.builder().id(1L).build())
                .category(Category.builder().id(2L).build())
                .build();

        when(itemService.update(any())).thenReturn(item);

        mockMvc.perform(put("/api/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(ResponseCode.SUCCESS.getCode()))
                .andExpect(jsonPath("$.data.name").value("수정된신발"));
    }

    @Test
    @DisplayName("DELETE /api/items/{itemId} - 아이템 삭제")
    void deleteItem() throws Exception {
        Long itemId = 10L;
        Item deleted = Item.builder()
                .id(itemId)
                .name("삭제된신발")
                .price(BigDecimal.valueOf(10000))
                .brand(Brand.builder().id(1L).build())
                .category(Category.builder().id(2L).build())
                .build();

        when(itemService.delete(itemId)).thenReturn(deleted);

        mockMvc.perform(delete("/api/items/{itemId}", itemId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(ResponseCode.SUCCESS.getCode()))
                .andExpect(jsonPath("$.data.name").value("삭제된신발"));
    }
}