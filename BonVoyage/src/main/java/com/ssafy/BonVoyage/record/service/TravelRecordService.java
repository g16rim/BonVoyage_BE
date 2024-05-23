package com.ssafy.BonVoyage.record.service;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.record.domain.TravelRecord;
import com.ssafy.BonVoyage.record.dto.TravelListRecordDto;
import com.ssafy.BonVoyage.record.dto.TravelRecordDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TravelRecordService {
    @Transactional
    Long create(TravelRecordDto dto, Member member);

    List<TravelListRecordDto> read(Long memberId);
//    TravelRecordDto update(TravelRecordDto dto);
    void delete(Long id);
}
