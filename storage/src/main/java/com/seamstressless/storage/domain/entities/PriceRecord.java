package com.seamstressless.storage.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "price_record")
public class PriceRecord {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "price_at", nullable = false)
    private String priceAt;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
