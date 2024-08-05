package com.seamstressless.storage.utils.dto.PriceRecord;

import java.time.LocalDateTime;

public record PriceRecordRes (
    Long Id,
    Double Price,
    LocalDateTime PriceAt,
    Long SupplyId
) {}
