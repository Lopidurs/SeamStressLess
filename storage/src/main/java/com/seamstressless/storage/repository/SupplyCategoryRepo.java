package com.seamstressless.storage.repository;

import com.seamstressless.storage.domain.entities.SupplyCategory;
import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplyCategoryRepo extends JpaRepository<SupplyCategory, Long> {
}
