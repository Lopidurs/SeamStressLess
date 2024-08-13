package com.seamstressless.storage.repository;

import com.seamstressless.storage.domain.entities.PriceRecord;
import com.seamstressless.storage.domain.entities.Supply;
import com.seamstressless.storage.utils.dto.PriceRecord.PriceRecordRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRecordRepo extends JpaRepository<PriceRecord, Long> {
    @Query("SELECT pr FROM PriceRecord pr "
            + "JOIN FETCH pr.supply s "
            + "WHERE pr.id = (SELECT MAX(pr2.id) FROM PriceRecord pr2 WHERE pr2.supply = pr.supply)")
    List<PriceRecord> findLatestPriceRecordForEachSupply();

}
