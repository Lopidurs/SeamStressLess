package com.seamstressless.storage.utils.dto.SupplyCategory;

import jakarta.validation.constraints.NotNull;

public record SupplyCategoryReq (
        @NotNull
        String name
){
}
