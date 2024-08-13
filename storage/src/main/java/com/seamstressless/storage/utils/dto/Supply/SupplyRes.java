package com.seamstressless.storage.utils.dto.Supply;

import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;

public record SupplyRes (
    Long id,
    String storeName,
    String URL,
    String xPathPrice,
    SupplyCategoryRes category,
    Double lastPrice

    ) {}
