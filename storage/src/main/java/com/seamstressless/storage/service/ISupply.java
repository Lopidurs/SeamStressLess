package com.seamstressless.storage.service;

import com.seamstressless.storage.utils.dto.Supply.SupplyReq;
import com.seamstressless.storage.utils.dto.Supply.SupplyRes;

import java.util.List;

/**
 * Service interface for supplies
 */
public interface ISupply {

    /**
     * Get all supplies
     * @return list of supplies
     */
    List<SupplyRes> getAllSupplies();

    /**
     * Get all supplies by category
     * @param categoryId category id
     * @return list of supplies
     */
    List<SupplyRes> getAllSuppliesByCategory(Long categoryId);

    /**
     * Add a new supply
     * @param supplyReq supply to create
     * @return created supply
     */
    SupplyRes addSupply(SupplyReq supplyReq);
}
