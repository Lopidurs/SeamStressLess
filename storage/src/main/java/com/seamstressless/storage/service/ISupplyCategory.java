package com.seamstressless.storage.service;

import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;

import java.util.List;

/**
 * Service interface for supplies category
 */
public interface ISupplyCategory {
    /**
     * Get all supplies categories
     * @return list of supplies categories
     */
    List<SupplyCategoryRes> getAllSupplyCategories();
}
