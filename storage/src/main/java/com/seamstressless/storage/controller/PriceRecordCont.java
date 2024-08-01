package com.seamstressless.storage.controller;

import com.seamstressless.storage.utils.dto.PriceRecord.PriceRecordReq;
import com.seamstressless.storage.utils.dto.PriceRecord.PriceRecordRes;
import com.seamstressless.storage.service.IPriceRecord;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price-records")
public class PriceRecordCont {

    private final IPriceRecord priceRecordService;

    @PostMapping
    List<PriceRecordRes> savePriceRecords(@RequestBody @Valid List<PriceRecordReq> priceRecords) {
        return priceRecordService.savePriceRecords(priceRecords);
    }
}
