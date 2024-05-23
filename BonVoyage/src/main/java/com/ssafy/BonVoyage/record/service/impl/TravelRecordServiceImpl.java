package com.ssafy.BonVoyage.record.service.impl;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.auth.repository.MemberRepository;
import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.group.repository.TravelGroupRepository;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import com.ssafy.BonVoyage.plan.repository.TravelPlanRepository;
import com.ssafy.BonVoyage.record.dto.TravelRecordDto;
import com.ssafy.BonVoyage.record.repository.TravelRecordRepository;
import com.ssafy.BonVoyage.record.service.TravelRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TravelRecordServiceImpl implements TravelRecordService {

    private final TravelPlanRepository travelPlanRepository;
    private final TravelRecordRepository recordRepository;
    private final TravelGroupRepository groupRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long create(TravelRecordDto dto, Member member) {
        TravelGroup group = groupRepository.findById(dto.getTravelGroupId())
                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다. id=" + dto.getTravelGroupId()));

        TravelPlan plan = travelPlanRepository.findById(dto.getTravelPlanId())
                .orElseThrow(() -> new IllegalStateException("해당 여행 계획이 존재하지 않습니다."));

        return recordRepository.save(dto.toEntity(group, plan, member)).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public TravelRecordDto read(Long id) {
        return TravelRecordDto.toDto(recordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 여행 기록이 존재하지 않습니다. id=" + id)));
    }

//    @Override
//    @Transactional
//    public TravelRecordDto update(TravelRecordDto dto) {
//        TravelGroup group = groupRepository.findById(dto.getTravelGroupId())
//                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다. id=" + dto.getTravelGroupId()));
//        return TravelRecordDto.toDto(recordRepository.save(dto.toEntity(group)));
//    }

    @Override
    @Transactional
    public void delete(Long id) {
        recordRepository.deleteById(id);
    }
}
