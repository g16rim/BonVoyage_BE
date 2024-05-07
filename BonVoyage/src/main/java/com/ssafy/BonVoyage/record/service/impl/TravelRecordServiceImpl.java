package com.ssafy.BonVoyage.record.service.impl;

import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.group.repository.TravelGroupRepository;
import com.ssafy.BonVoyage.record.dto.TravelRecordDto;
import com.ssafy.BonVoyage.record.repository.TravelRecordRepository;
import com.ssafy.BonVoyage.record.service.TravelRecordService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TravelRecordServiceImpl implements TravelRecordService {

    private TravelRecordRepository recordRepository;
    private TravelGroupRepository groupRepository;

    @Override
    @Transactional
    public Long create(TravelRecordDto dto) {
        TravelGroup group = groupRepository.findById(dto.getTravelGroupId())
                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다. id=" + dto.getTravelGroupId()));
        return recordRepository.save(dto.toEntity(group)).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public TravelRecordDto read(Long id) {
        return TravelRecordDto.toDto(recordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 여행 기록이 존재하지 않습니다. id=" + id)));
    }

    @Override
    @Transactional
    public TravelRecordDto update(TravelRecordDto dto) {
        TravelGroup group = groupRepository.findById(dto.getTravelGroupId())
                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다. id=" + dto.getTravelGroupId()));
        return TravelRecordDto.toDto(recordRepository.save(dto.toEntity(group)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        recordRepository.deleteById(id);
    }
}
