package com.seamstressless.storage.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "supplies")
public class Supply extends BaseEntity<Long> {

    @Column(name = "URL", nullable = false)
    private String URL;

    @Column(name = "xPathPrice", nullable = false)
    private String xPathPrice;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private SupplyCategory category;
}
