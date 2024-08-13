package com.seamstressless.storage.datainitializer;

import com.seamstressless.storage.domain.entities.SupplyCategory;
import com.seamstressless.storage.repository.SupplyCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(1)
public class SupplyCategoryInit implements CommandLineRunner {

    private final SupplyCategoryRepo supplyCategoryRepo;


    @Override
    public void run(String... args) throws Exception {
        List<SupplyCategory> productCategories = List.of(
                new SupplyCategory("Calicot blanc"),
                new SupplyCategory("Cotton rouge"),
                new SupplyCategory("Cotton bleu"),
                new SupplyCategory("Tirettes")
        );

        supplyCategoryRepo.saveAll(productCategories);

    }
}
