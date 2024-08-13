package com.seamstressless.storage.utils.mapper;

import com.seamstressless.storage.domain.entities.PriceRecord;
import com.seamstressless.storage.domain.entities.Supply;
import com.seamstressless.storage.repository.PriceRecordRepo;
import com.seamstressless.storage.repository.SupplyCategoryRepo;
import com.seamstressless.storage.repository.SupplyRepo;
import com.seamstressless.storage.utils.dto.Supply.SupplyRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SupplyMapper {
    private final SupplyRepo supplyRepo;
    private final SupplyCategoryRepo supplyCategoryRepo;
    private final PriceRecordRepo priceRecordRepo;
    private final SupplyCategoryMapper supplyCategoryMapper;

    public static SupplyRes fromEntity(Supply supply, PriceRecord priceRecord) {
        return new SupplyRes(
                supply.getId(),
                supply.getStoreName(),
                supply.getURL(),
                supply.getXPathPrice(),
                SupplyCategoryMapper.fromEntity(supply.getCategory()),
                priceRecord != null ? priceRecord.getPrice() : null
        );
    }
}
