package com.seamstressless.storage.utils.mapper;

import com.seamstressless.storage.domain.entities.PriceRecord;
import com.seamstressless.storage.domain.entities.Supply;
import com.seamstressless.storage.repository.PriceRecordRepo;
import com.seamstressless.storage.repository.SupplyCategoryRepo;
import com.seamstressless.storage.repository.SupplyRepo;
import com.seamstressless.storage.utils.dto.Supply.SupplyReq;
import com.seamstressless.storage.utils.dto.Supply.SupplyRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SupplyMapper {
    private final SupplyCategoryRepo supplyCategoryRepo;


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

    public Supply toEntity(SupplyReq supplyReq) {
        return new Supply(
                supplyReq.URL(),
                supplyReq.storeName(),
                supplyReq.xPathPrice(),
                supplyCategoryRepo.findById(supplyReq.categoryId()).orElseThrow()
        );
    }
}
