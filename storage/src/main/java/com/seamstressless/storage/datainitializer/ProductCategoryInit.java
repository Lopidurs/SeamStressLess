package com.seamstressless.storage.datainitializer;

import com.seamstressless.storage.domain.entities.ProductCategory;
import com.seamstressless.storage.repository.ProductCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(1)
public class ProductCategoryInit implements CommandLineRunner {

    private final ProductCategoryRepo productCategoryRepo;


    @Override
    public void run(String... args) throws Exception {
        List<ProductCategory> productCategories = List.of(
                new ProductCategory("Calicot blanc"),
                new ProductCategory("Cotton rouge"),
                new ProductCategory("Cottton bleu"),
                new ProductCategory("Tirettes")
        );

        productCategoryRepo.saveAll(productCategories);

    }
}
