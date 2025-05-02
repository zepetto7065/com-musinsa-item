package com.musinsa.product.application.api.item;

import com.musinsa.product.application.api.item.payload.ItemConverter;
import com.musinsa.product.application.api.item.payload.ItemMinPricePerCategorySummaryResponse;
import com.musinsa.product.application.api.item.payload.PriceSummaryByCategoryResponse;
import com.musinsa.product.application.api.item.payload.SingleBrandMinSummaryResponse;
import com.musinsa.product.core.service.item.summary.PriceSummary;
import com.musinsa.product.core.service.item.ItemSummaryService;
import com.musinsa.product.core.service.item.summary.MinItemSummary;
import com.musinsa.product.core.service.item.summary.SingleBrandMinItemSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/item-summary")
public class ItemSummaryController {

    private final ItemSummaryService itemSummaryService;
    @GetMapping("/min-price")
    public ResponseEntity<ItemMinPricePerCategorySummaryResponse> minPriceSummary(){
        MinItemSummary minPricePerCategory = itemSummaryService.getMinPricePerCategory();

        ItemMinPricePerCategorySummaryResponse response = ItemConverter.INSTANCE.map(minPricePerCategory);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/single-brand")
    public ResponseEntity<SingleBrandMinSummaryResponse> getSingleBrandMinSummary() {
        SingleBrandMinItemSummary summary = itemSummaryService.getSingleBrandMinSummary();

        SingleBrandMinSummaryResponse singleBrandMinSummaryResponse = ItemConverter.INSTANCE.mapTo(summary);

        return ResponseEntity.ok(singleBrandMinSummaryResponse);
    }

    @GetMapping("/price")
    public ResponseEntity<PriceSummaryByCategoryResponse> getPriceSummary(@RequestParam String categoryName){
        PriceSummary summary = itemSummaryService.getPriceSummary(categoryName);

        PriceSummaryByCategoryResponse response = ItemConverter.INSTANCE.map(summary);

        return ResponseEntity.ok(response);
    }
}
