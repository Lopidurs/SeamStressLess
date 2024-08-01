package com.seamstressless.storage.utils.dto.PriceRecord;

import com.seamstressless.storage.domain.entities.PriceRecord;
import com.seamstressless.storage.domain.entities.Product;
import com.seamstressless.storage.repository.ProductRepo;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
public record PriceRecordReq (
    @NotNull
    Double price,
    @NotNull
    LocalDateTime priceAt,
    @NotNull
    Long productId
) {}
