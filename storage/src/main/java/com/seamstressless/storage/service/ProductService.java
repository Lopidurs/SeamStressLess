package com.seamstressless.storage.service;

import com.seamstressless.storage.dto.Product.ProductRes;
import com.seamstressless.storage.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProduct {

        private final ProductRepo productRepo;

        @Override
        public List<ProductRes> getAllProducts() {
            System.out.println(productRepo.findAll());
            return productRepo.findAllProduct();
        }
}
