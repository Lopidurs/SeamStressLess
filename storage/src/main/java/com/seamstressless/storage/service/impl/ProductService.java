package com.seamstressless.storage.service.impl;

import com.seamstressless.storage.utils.dto.Product.ProductRes;
import com.seamstressless.storage.repository.ProductRepo;
import com.seamstressless.storage.service.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProduct {

        private final ProductRepo productRepo;

        @Override
        public List<ProductRes> getAllProducts() {
            return productRepo.findAllProduct();
        }
}
