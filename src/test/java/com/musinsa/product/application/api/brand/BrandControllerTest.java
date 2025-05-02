package com.musinsa.product.application.api.brand;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musinsa.product.application.api.brand.payload.SaveBrandRequest;
import com.musinsa.product.comm.ResponseCode;
import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.service.brand.BrandService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BrandController.class)
class BrandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrandService brandService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("브랜드 생성 API 테스트")
    void testCreateBrand() throws Exception {
        SaveBrandRequest request = new SaveBrandRequest("나이키");
        Brand mockBrand = Brand.builder().id(1L).name("나이키").build();

        Mockito.when(brandService.create(any())).thenReturn(mockBrand);

        mockMvc.perform(post("/api/brands")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value(ResponseCode.CREATED.getCode()))
                .andExpect(jsonPath("$.data.name").value("나이키"));
    }

    @Test
    @DisplayName("브랜드 수정 API 테스트")
    void testUpdateBrand() throws Exception {
        Long brandId = 1L;
        SaveBrandRequest request = new SaveBrandRequest("아디다스로수정");
        Brand updatedBrand = Brand.builder().id(brandId).name("아디다스로수정").build();

        Mockito.when(brandService.update(any())).thenReturn(updatedBrand);

        mockMvc.perform(put("/api/brands/{brandId}", brandId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(ResponseCode.SUCCESS.getCode()))
                .andExpect(jsonPath("$.data.name").value("아디다스로수정"));
    }

    @Test
    @DisplayName("브랜드 삭제 API 테스트")
    void testDeleteBrand() throws Exception {
        Long brandId = 1L;
        Brand deletedBrand = Brand.builder().id(brandId).name("뉴발란스").build();

        Mockito.when(brandService.delete(eq(brandId))).thenReturn(deletedBrand);

        mockMvc.perform(delete("/api/brands/{brandId}", brandId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(ResponseCode.SUCCESS.getCode()))
                .andExpect(jsonPath("$.data.name").value("뉴발란스"));
    }
}