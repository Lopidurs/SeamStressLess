package com.seamstressless.storage.service.impl;

import com.seamstressless.storage.utils.dto.Supply.SupplyRes;
import com.seamstressless.storage.repository.SupplyRepo;
import com.seamstressless.storage.service.ISupply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyService implements ISupply {

        private final SupplyRepo supplyRepo;

        @Override
        public List<SupplyRes> getAllSupplies() {
            return supplyRepo.findAllProduct();
        }
}
