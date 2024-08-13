package com.seamstressless.storage.utils.dto.Supply;

import jakarta.validation.constraints.NotNull;

public record SupplyReq(
        @NotNull
        String URL,
        @NotNull
        String storeName,
        @NotNull
        String xPathPrice,
        @NotNull
        Long categoryId
) {
}
