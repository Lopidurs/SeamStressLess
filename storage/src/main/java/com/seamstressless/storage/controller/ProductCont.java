package com.seamstressless.storage.controller;

import com.seamstressless.storage.utils.dto.Product.ProductRes;
import com.seamstressless.storage.service.IProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductCont {

    private final IProduct productService;

    @GetMapping
    public List<ProductRes> getAllProducts() {
        System.out.println(productService.getAllProducts());
        return productService.getAllProducts();
    }
}
