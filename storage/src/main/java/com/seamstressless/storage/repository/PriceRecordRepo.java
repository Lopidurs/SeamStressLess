package com.seamstressless.storage.repository;

import com.seamstressless.storage.domain.entities.PriceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRecordRepo extends JpaRepository<PriceRecord, Long> {
}
