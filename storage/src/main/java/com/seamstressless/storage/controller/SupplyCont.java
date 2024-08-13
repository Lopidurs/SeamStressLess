package com.seamstressless.storage.controller;

import com.seamstressless.storage.service.ISupplyCategory;
import com.seamstressless.storage.utils.dto.Supply.SupplyReq;
import com.seamstressless.storage.utils.dto.Supply.SupplyRes;
import com.seamstressless.storage.service.ISupply;
import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public SupplyRes addSupply(@RequestBody @Valid SupplyReq supplyReq) {
        System.out.println(supplyReq.URL());
        return supplyService.addSupply(supplyReq);
    }
}
