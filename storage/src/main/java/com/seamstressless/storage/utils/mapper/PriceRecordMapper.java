package com.seamstressless.storage.utils.mapper;

import com.seamstressless.storage.domain.entities.PriceRecord;
import com.seamstressless.storage.repository.SupplyRepo;
import com.seamstressless.storage.utils.dto.PriceRecord.PriceRecordReq;
import com.seamstressless.storage.utils.dto.PriceRecord.PriceRecordRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PriceRecordMapper {
    private final SupplyRepo supplyRepo;

    public PriceRecord toEntity(PriceRecordReq priceRecordReq) {
        return new PriceRecord(
                priceRecordReq.price(),
                priceRecordReq.priceAt(),
                supplyRepo.findById(priceRecordReq.supplyId())
                        .orElseThrow(() -> new IllegalArgumentException("Product not found"))
        );
    }

    public PriceRecordRes fromEntity(PriceRecord priceRecord) {
        return new PriceRecordRes(
                priceRecord.getId(),
                priceRecord.getPrice(),
                priceRecord.getPriceAt(),
                priceRecord.getSupply().getId()
        );
    }
}
