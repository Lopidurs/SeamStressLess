package com.seamstressless.storage.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "products_categories")
public class ProductCategory extends BaseEntity<Long> {

    @Column(name = "name", nullable = false)
    private String name;
}
