package com.seamstressless.storage.service.impl;

import com.seamstressless.storage.repository.SupplyCategoryRepo;
import com.seamstressless.storage.service.ISupplyCategory;
import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;
import com.seamstressless.storage.utils.mapper.SupplyCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyCategoryService implements ISupplyCategory {
    private final SupplyCategoryRepo supplyCategoryRepo;

    public List<SupplyCategoryRes> getAllSupplyCategories() {
        return supplyCategoryRepo.findAll().stream()
                .map(SupplyCategoryMapper::fromEntity)
                .toList();
    }
}
