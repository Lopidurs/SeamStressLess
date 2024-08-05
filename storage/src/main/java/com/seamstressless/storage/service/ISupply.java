package com.seamstressless.storage.service;

import com.seamstressless.storage.utils.dto.Supply.SupplyRes;

import java.util.List;

/**
 * Service interface for product
 */
public interface ISupply {

    /**
     * Get all products
     * @return list of products
     */
    List<SupplyRes> getAllSupplies();
}
