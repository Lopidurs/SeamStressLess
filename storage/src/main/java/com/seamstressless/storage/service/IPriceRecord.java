package com.seamstressless.storage.service;

import com.seamstressless.storage.utils.dto.PriceRecord.PriceRecordReq;
import com.seamstressless.storage.utils.dto.PriceRecord.PriceRecordRes;

import java.util.List;

/**
 * Service interface for price record
 */
public interface IPriceRecord {

    /**
     * Save price records
     * @param priceRecords list of price records
     */
    List<PriceRecordRes> savePriceRecords(List<PriceRecordReq> priceRecords);
}
