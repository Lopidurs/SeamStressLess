package com.seamstressless.storage.utils.dto.PriceRecord;

import com.seamstressless.storage.domain.entities.PriceRecord;
import com.seamstressless.storage.domain.entities.Product;

import java.time.LocalDateTime;

public record PriceRecordRes (
    Long Id,
    Double Price,
    LocalDateTime PriceAt,
    Long ProductId
) {}
