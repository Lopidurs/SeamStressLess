package com.seamstressless.storage.utils.dto.PriceRecord;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
public record PriceRecordReq (
    @NotNull
    Double price,
    @NotNull
    LocalDateTime priceAt,
    @NotNull
    Long supplyId
) {}
