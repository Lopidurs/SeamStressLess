package com.seamstressless.storage.datainitializer;

import com.seamstressless.storage.domain.entities.Supply;
import com.seamstressless.storage.domain.entities.SupplyCategory;
import com.seamstressless.storage.repository.SupplyCategoryRepo;
import com.seamstressless.storage.repository.SupplyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(2)

public class ProductInit implements CommandLineRunner {

    private final SupplyRepo supplyRepo;
    private final SupplyCategoryRepo supplyCategoryRepo;

    @Override
    public void run(String... args) throws Exception {
        List<SupplyCategory> productCategories = supplyCategoryRepo.findAll();

        List<Supply> supplies = List.of(
                new Supply("https://www.stragier.com/fr/article/298069/calicot-coton-souple-uni-blanc", "/html/body/form/div[4]/div[1]/div[6]/div/div[3]/div[2]/span[2]", productCategories.get(0)),
                new Supply("https://verotex.be/products/tissu-calicot", "/html/body/main/section[1]/div/product-rerender/div/safe-sticky/div[4]/div/div/price-list/sale-price", productCategories.get(0))
                );

        supplyRepo.saveAll(supplies);
    }

}
