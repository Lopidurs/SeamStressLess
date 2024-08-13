package com.seamstressless.storage.utils.mapper;

import com.seamstressless.storage.domain.entities.SupplyCategory;
import com.seamstressless.storage.repository.SupplyCategoryRepo;
import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryReq;
import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SupplyCategoryMapper {

    public static SupplyCategoryRes fromEntity(SupplyCategory supplyCategory) {
        return new SupplyCategoryRes(
                supplyCategory.getId(),
                supplyCategory.getName()
        );
    }

    public static SupplyCategory toEntity(SupplyCategoryReq supplyCategoryReq) {
        return new SupplyCategory(
                supplyCategoryReq.name()
        );
    }

}
