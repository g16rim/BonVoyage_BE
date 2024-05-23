package com.ssafy.BonVoyage.record.service;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.record.dto.TravelRecordDto;
import org.springframework.transaction.annotation.Transactional;

public interface TravelRecordService {
    @Transactional
    Long create(TravelRecordDto dto, Member member);

    TravelRecordDto read(Long id);
//    TravelRecordDto update(TravelRecordDto dto);
    void delete(Long id);
}
