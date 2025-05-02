package com.musinsa.product.application.api.brand;

import com.musinsa.product.application.api.brand.payload.BrandConverter;
import com.musinsa.product.application.api.brand.payload.BrandSaveResponse;
import com.musinsa.product.application.api.brand.payload.SaveBrandRequest;
import com.musinsa.product.comm.ApiCommonResponse;
import com.musinsa.product.comm.ResponseCode;
import com.musinsa.product.core.domain.Brand;
import com.musinsa.product.core.service.brand.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<ApiCommonResponse> create(@Valid @RequestBody SaveBrandRequest command){
        Brand brand = brandService.create(command.getName());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiCommonResponse.of(ResponseCode.CREATED.getCode()
                        , ResponseCode.CREATED.getMessage(), BrandConverter.INSTANCE.map(brand)));
    }

    @PutMapping("/{brandId}")
    public ResponseEntity<ApiCommonResponse<BrandSaveResponse>> update(@PathVariable Long brandId, @RequestBody SaveBrandRequest request){
        Brand command = Brand.builder()
                .id(brandId)
                .name(request.getName())
                .build();
        Brand update = brandService.update(command);
        BrandSaveResponse response = BrandConverter.INSTANCE.map(update);
        return ResponseEntity.ok(
                ApiCommonResponse.of(
                        ResponseCode.SUCCESS.getCode()
                        , ResponseCode.SUCCESS.getMessage()
                        , response));
    }

    @DeleteMapping("/{brandId}")
    public ResponseEntity<ApiCommonResponse<BrandSaveResponse>> delete(@PathVariable Long brandId){
        Brand delete = brandService.delete(brandId);
        return ResponseEntity.ok(
                ApiCommonResponse.of(
                        ResponseCode.SUCCESS.getCode(),
                        ResponseCode.SUCCESS.getMessage(),
                        BrandConverter.INSTANCE.map(delete)));
    }

}
