package com.seamstressless.storage.datainitializer;

import com.seamstressless.storage.domain.entities.PriceRecord;
import com.seamstressless.storage.domain.entities.Supply;
import com.seamstressless.storage.repository.PriceRecordRepo;
import com.seamstressless.storage.repository.SupplyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(3)

public class PriceRecordInit implements CommandLineRunner {
    private final PriceRecordRepo priceRecordRepo;
    private final SupplyRepo supplyRepo;

    @Override
    public void run(String... args) throws Exception {
        List<Supply> supplies = supplyRepo.findAll();

        List<PriceRecord> priceRecords = List.of(
                new PriceRecord(10.0, LocalDateTime.parse("2024-08-08T12:31:21.462603"), supplies.get(0)),
                new PriceRecord(20.0, LocalDateTime.parse("2024-08-08T12:31:21.462603"), supplies.get(1)),
                new PriceRecord(30.0, LocalDateTime.parse("2024-08-08T12:31:21.462603"), supplies.get(2))
        );

        priceRecordRepo.saveAll(priceRecords);
    }
}
