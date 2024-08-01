package com.seamstressless.storage.service.impl;

import com.seamstressless.storage.domain.entities.PriceRecord;
import com.seamstressless.storage.utils.dto.PriceRecord.PriceRecordReq;
import com.seamstressless.storage.utils.dto.PriceRecord.PriceRecordRes;
import com.seamstressless.storage.repository.PriceRecordRepo;
import com.seamstressless.storage.service.IPriceRecord;
import com.seamstressless.storage.utils.mapper.PriceRecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceRecordService implements IPriceRecord {

    private final PriceRecordRepo priceRecordRepo;
    private final PriceRecordMapper priceRecordMapper;

    @Override
    public List<PriceRecordRes> savePriceRecords(List<PriceRecordReq> priceRecords) {
        List<PriceRecord> priceRecordList = priceRecords.stream()
                .map(priceRecordMapper::toEntity)
                .toList();

        return priceRecordRepo.saveAll(priceRecordList).stream()
                .map(priceRecordMapper::fromEntity)
                .toList();
    }
}
