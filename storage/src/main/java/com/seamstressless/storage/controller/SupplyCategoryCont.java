package com.seamstressless.storage.controller;

import com.seamstressless.storage.service.ISupplyCategory;
import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryReq;
import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supply-category")
public class SupplyCategoryCont {

    private final ISupplyCategory supplyCategoryService;

    @GetMapping()
    public List<SupplyCategoryRes> getAllSupplyCategories() {
        return supplyCategoryService.getAllSupplyCategories();
    }

    @PostMapping()
    public SupplyCategoryRes addSupplyCategory(@RequestBody @Valid SupplyCategoryReq supplyCategoryReq) {
        return supplyCategoryService.addSupplyCategory(supplyCategoryReq);
    }
}
