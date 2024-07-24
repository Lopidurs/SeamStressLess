package com.seamstressless.storage.service;

import com.seamstressless.storage.dto.Product.ProductRes;

import java.util.List;

/**
 * Service interface for product
 */
public interface IProduct {

    /**
     * Get all products
     * @return list of products
     */
    List<ProductRes> getAllProducts();
}
