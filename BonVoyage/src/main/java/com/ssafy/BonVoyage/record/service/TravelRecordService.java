package com.ssafy.BonVoyage.record.service;

import com.ssafy.BonVoyage.record.dto.TravelRecordDto;

public interface TravelRecordService {
    Long create(TravelRecordDto dto);
    TravelRecordDto read(Long id);
    TravelRecordDto update(TravelRecordDto dto);
    void delete(Long id);
}
