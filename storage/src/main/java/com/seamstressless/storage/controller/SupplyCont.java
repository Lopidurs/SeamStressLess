package com.seamstressless.storage.controller;

import com.seamstressless.storage.service.ISupplyCategory;
import com.seamstressless.storage.utils.dto.Supply.SupplyRes;
import com.seamstressless.storage.service.ISupply;
import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplies")
public class SupplyCont {

    private final ISupply supplyService;

    @GetMapping
    public List<SupplyRes> getAllSupplies() {
        return supplyService.getAllSupplies();
    }

    @GetMapping("/{categoryId}")
    public List<SupplyRes> getAllSuppliesByCategory(@PathVariable Long categoryId) {
        return supplyService.getAllSuppliesByCategory(categoryId);
    }
}
