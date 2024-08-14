package com.seamstressless.storage.service;

import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryReq;
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

    /**
     * Get a supply category by id
     * @param id supply category id
     * @return supply category
     */
    SupplyCategoryRes getSupplyCategory(Long id);

    /**
     * Add a new supply category
     * @param supplyCategoryReq supply category to create
     * @return created supply category
     */
    SupplyCategoryRes addSupplyCategory(SupplyCategoryReq supplyCategoryReq);
}
