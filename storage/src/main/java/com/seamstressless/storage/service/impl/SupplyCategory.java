package com.seamstressless.storage.service.impl;

import com.seamstressless.storage.repository.SupplyCategoryRepo;
import com.seamstressless.storage.service.ISupplyCategory;
import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyCategory implements ISupplyCategory {
    private final SupplyCategoryRepo supplyCategoryRepo;

    public List<SupplyCategoryRes> getAllSupplyCategories() {
        return supplyCategoryRepo.findAllSupplyCategory();
    }
}
