package com.ssafy.BonVoyage.plan.service.impl;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.auth.repository.MemberRepository;
import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.group.repository.TravelGroupRepository;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import com.ssafy.BonVoyage.plan.dto.TravelPlanDto;
import com.ssafy.BonVoyage.plan.repository.TravelPlanRepository;
import com.ssafy.BonVoyage.plan.service.TravelPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TravelPlanServiceImpl implements TravelPlanService {

    private final TravelPlanRepository planRepository;
    private final TravelGroupRepository groupRepository;
    private final MemberRepository memberRepository;

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
    public TravelPlanDto update(Long planId, TravelPlanDto dto) {
        TravelGroup group = groupRepository.findById(dto.getTravelGroupId())
                .orElseThrow(() -> new IllegalArgumentException("해당 그룹이 존재하지 않습니다. id=" + dto.getTravelGroupId()));
        TravelPlan plan = planRepository.findById(planId).get();
        plan.update(dto.getPlanTitle(), dto.getStartDate(), dto.getEndDate(), dto.getBudget()); // jpa dirty checking
        return TravelPlanDto.toDto(planRepository.findById(plan.getId()).get());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TravelPlanDto> list(String userEmail) {
        // 1. user group 조회
        Member member = memberRepository.findByEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 존재하지 않습니다. id=" + userEmail));
        List<TravelGroup> userGroup = groupRepository.findAllByMemberId(member.getId());
        List<Long> groupIds = userGroup.stream().map(TravelGroup::getId).collect(Collectors.toList());

        // 2. group별 여행 조회
        List<TravelPlan> travelPlans = planRepository.findByTravelGroupIn(userGroup);

        return travelPlans.stream()
                .map(travelPlan -> TravelPlanDto.toDto(travelPlan))
                .collect(Collectors.toList());
    }
}
