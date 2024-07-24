package com.seamstressless.storage.repository;

import com.seamstressless.storage.domain.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
}
