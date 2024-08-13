package com.seamstressless.storage.service.impl;

import com.seamstressless.storage.domain.entities.PriceRecord;
import com.seamstressless.storage.domain.entities.Supply;
import com.seamstressless.storage.repository.PriceRecordRepo;
import com.seamstressless.storage.repository.SupplyCategoryRepo;
import com.seamstressless.storage.utils.dto.Supply.SupplyRes;
import com.seamstressless.storage.repository.SupplyRepo;
import com.seamstressless.storage.service.ISupply;
import com.seamstressless.storage.utils.mapper.SupplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplyService implements ISupply {

    private final SupplyRepo supplyRepo;
    private final SupplyMapper supplyMapper;
    private final PriceRecordRepo priceRecordRepo;
    private final SupplyCategoryRepo supplyCategoryRepo;

    @Override
    public List<SupplyRes> getAllSupplies() {
        List<Supply> supplies = supplyRepo.findAll();
        return getSuppliesWithLastPrice(supplies);
    }

    @Override
    public List<SupplyRes> getAllSuppliesByCategory(Long categoryId) {
        List<Supply> supplies = supplyRepo.findAllByCategory(categoryId);
        return getSuppliesWithLastPrice(supplies);
    }

    private List<SupplyRes> getSuppliesWithLastPrice(List<Supply> supplies) {
        List<PriceRecord> priceRecords = priceRecordRepo.findLatestPriceRecordForEachSupply();

        return supplies.stream().map(supply -> {
            Optional<PriceRecord> priceRecord = priceRecords.stream().filter(pr -> pr.getSupply().getId().equals(supply.getId())).findFirst();
            assert priceRecord.orElse(null) != null;
            return SupplyMapper.fromEntity(supply, priceRecord.orElse(null));
        }).toList();
    }
}
