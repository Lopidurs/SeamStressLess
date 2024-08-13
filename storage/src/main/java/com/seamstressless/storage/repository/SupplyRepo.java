package com.seamstressless.storage.repository;

import com.seamstressless.storage.domain.entities.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepo extends JpaRepository<Supply, Long> {

    @Query("SELECT p FROM Supply p WHERE p.category.id = :categoryId")
    List<Supply> findAllByCategory(Long categoryId);
}
