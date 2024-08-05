package com.seamstressless.storage.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "price_records")
public class PriceRecord extends BaseEntity<Long>{

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "price_at", nullable = false)
    private LocalDateTime priceAt;

    @ManyToOne
    @JoinColumn(name = "supply_id", nullable = false)
    private Supply supply;
}
