package com.seamstressless.storage.datainitializer;

import com.seamstressless.storage.domain.entities.Product;
import com.seamstressless.storage.domain.entities.ProductCategory;
import com.seamstressless.storage.repository.ProductCategoryRepo;
import com.seamstressless.storage.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(2)

public class ProductInit implements CommandLineRunner {

    private final ProductRepo productRepo;
    private final ProductCategoryRepo productCategoryRepo;

    @Override
    public void run(String... args) throws Exception {
        List<ProductCategory> productCategories = productCategoryRepo.findAll();

        List<Product> products = List.of(
                new Product("https://www.stragier.com/fr/article/298069/calicot-coton-souple-uni-blanc", "/html/body/form/div[4]/div[1]/div[6]/div/div[3]/div[2]/span[2]", productCategories.get(0)),
                new Product("https://verotex.be/products/tissu-calicot", "/html/body/main/section[1]/div/product-rerender/div/safe-sticky/div[4]/div/div/price-list/sale-price", productCategories.get(0))
                );

        productRepo.saveAll(products);
    }

}
