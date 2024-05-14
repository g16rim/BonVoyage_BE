package com.ssafy.BonVoyage.plan.service.impl;

import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.group.repository.TravelGroupRepository;
import com.ssafy.BonVoyage.plan.dto.TravelPlanDto;
import com.ssafy.BonVoyage.plan.repository.TravelPlanRepository;
import com.ssafy.BonVoyage.plan.service.TravelPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TravelPlanServiceImpl implements TravelPlanService {

    private final TravelPlanRepository planRepository;
    private final TravelGroupRepository groupRepository;

    @Override
    @Transactional
    public Long create(TravelPlanDto dto) {
        TravelGroup group = groupRepository.findById(dto.getTravelGroupId())
                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다. id=" + dto.getTravelGroupId()));
        return planRepository.save(dto.toEntity(group)).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public TravelPlanDto read(Long id) {
        return TravelPlanDto.toDto(planRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 계획이 존재하지 않습니다. id=" + id)));
    }

    @Override
    @Transactional
    public TravelPlanDto update(TravelPlanDto dto) {
        TravelGroup group = groupRepository.findById(dto.getTravelGroupId())
                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다. id=" + dto.getTravelGroupId()));
        return TravelPlanDto.toDto(planRepository.save(dto.toEntity(group)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        planRepository.deleteById(id);
    }
}
