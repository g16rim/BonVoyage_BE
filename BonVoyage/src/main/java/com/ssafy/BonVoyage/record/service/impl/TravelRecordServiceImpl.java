package com.ssafy.BonVoyage.record.service.impl;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.auth.repository.MemberRepository;
import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.group.repository.TravelGroupRepository;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import com.ssafy.BonVoyage.plan.repository.TravelPlanRepository;
import com.ssafy.BonVoyage.record.domain.TravelRecord;
import com.ssafy.BonVoyage.record.dto.RecordCommentDto;
import com.ssafy.BonVoyage.record.dto.TravelListRecordDto;
import com.ssafy.BonVoyage.record.dto.TravelRecordDto;
import com.ssafy.BonVoyage.record.repository.TravelRecordRepository;
import com.ssafy.BonVoyage.record.service.TravelRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelRecordServiceImpl implements TravelRecordService {

    private final TravelPlanRepository travelPlanRepository;
    private final TravelRecordRepository recordRepository;
    private final TravelGroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final TravelRecordRepository travelRecordRepository;

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
    public List<TravelListRecordDto> read(Long memberId) {
        List<TravelGroup> myGroup = groupRepository.findAllByMemberId(memberId);
        List<TravelListRecordDto> recordDtoList = new ArrayList<>();
        List<RecordCommentDto> travelRecordDtoList = new ArrayList<>();
        for (TravelGroup travelGroup : myGroup) {
            List<TravelRecord> groupRecords = recordRepository.findAllByTravelGroup(travelGroup);

            for (TravelRecord groupRecord : groupRecords) {
                RecordCommentDto travelRecordDto = new RecordCommentDto(groupRecord.getComment(), groupRecord.getMember());
                travelRecordDtoList.add(travelRecordDto);
            }

            TravelPlan travelPlan = groupRecords.get(0).getTravelPlan();
            TravelListRecordDto listRecordDto = new TravelListRecordDto(travelRecordDtoList, travelGroup, travelPlan);
            recordDtoList.add(listRecordDto);
        }

        return recordDtoList;
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
