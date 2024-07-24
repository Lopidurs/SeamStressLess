package com.seamstressless.storage.repository;

import com.seamstressless.storage.domain.entities.Product;
import com.seamstressless.storage.dto.Product.ProductRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p")
    List<ProductRes> findAllProduct();
}
