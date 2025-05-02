package com.musinsa.product.application.api.item;

import com.musinsa.product.application.api.item.payload.ItemConverter;
import com.musinsa.product.application.api.item.payload.ItemSaveResponse;
import com.musinsa.product.application.api.item.payload.SaveItemRequest;
import com.musinsa.product.comm.ApiCommonResponse;
import com.musinsa.product.comm.ResponseCode;
import com.musinsa.product.core.domain.Item;
import com.musinsa.product.core.service.item.ItemService;
import com.musinsa.product.core.service.item.ItemVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;
    @PostMapping
    public ResponseEntity<ApiCommonResponse> create(@Valid @RequestBody SaveItemRequest request){
        Item item = itemService.create(ItemVo.builder()
                .name(request.getName())
                .price(request.getPrice())
                .brandId(request.getBrandId())
                .categoryId(request.getCategoryId())
                .build());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiCommonResponse.of(ResponseCode.CREATED.getCode()
                        , ResponseCode.CREATED.getMessage(), ItemConverter.INSTANCE.map(item)));
    }

    @PutMapping
    public ResponseEntity<ApiCommonResponse<ItemSaveResponse>> update(@Valid @RequestBody SaveItemRequest request){
        Item update = itemService.update(ItemVo.builder()
                        .itemId(request.getItemId())
                        .name(request.getName())
                        .price(request.getPrice())
                        .brandId(request.getBrandId())
                        .categoryId(request.getCategoryId())
                .build());
        return ResponseEntity.ok(
                ApiCommonResponse.of(
                        ResponseCode.SUCCESS.getCode()
                        , ResponseCode.SUCCESS.getMessage()
                        , ItemConverter.INSTANCE.map(update)));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<ApiCommonResponse<ItemSaveResponse>> delete(@PathVariable Long itemId){
        Item delete = itemService.delete(itemId);
        return ResponseEntity.ok(
                ApiCommonResponse.of(
                        ResponseCode.SUCCESS.getCode(),
                        ResponseCode.SUCCESS.getMessage(),
                        ItemConverter.INSTANCE.map(delete)));
    }

}
