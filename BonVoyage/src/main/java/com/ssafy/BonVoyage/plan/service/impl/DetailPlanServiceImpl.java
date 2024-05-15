package com.ssafy.BonVoyage.plan.service.impl;

import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import com.ssafy.BonVoyage.plan.dto.DetailPlanDto;
import com.ssafy.BonVoyage.plan.repository.DetailPlanRepository;
import com.ssafy.BonVoyage.plan.repository.TravelPlanRepository;
import com.ssafy.BonVoyage.plan.service.DetailPlanService;
import com.ssafy.BonVoyage.site.domain.TravelSite;
import com.ssafy.BonVoyage.site.repository.TravelSiteRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DetailPlanServiceImpl implements DetailPlanService {

    private DetailPlanRepository detailPlanRepository;
    private TravelPlanRepository travelPlanRepository;
    private TravelSiteRepository siteRepository;

    @Override
    @Transactional
    public Long create(DetailPlanDto dto) {
        TravelPlan plan = travelPlanRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new IllegalArgumentException("해당 계획이 존재하지 않습니다. id=" + dto.getPlanId()));
        // TODO: travel site
        TravelSite site = siteRepository.findById(dto.getSiteId())
                .orElseThrow(() -> new IllegalArgumentException("해당 여행지가 존재하지 않습니다. id=" + dto.getSiteId()));
        return detailPlanRepository.save(dto.toEntity(plan, site)).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public DetailPlanDto read(Long id) {
        return DetailPlanDto.toDto(detailPlanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상세 계획이 존재하지 않습니다. id=" + id)));
    }

    @Override
    @Transactional
    public DetailPlanDto update(DetailPlanDto dto) {
        TravelPlan plan = travelPlanRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new IllegalArgumentException("해당 계획이 존재하지 않습니다. id=" + dto.getPlanId()));
        // TODO: travel site
        TravelSite site = siteRepository.findById(dto.getSiteId())
                .orElseThrow(() -> new IllegalArgumentException("해당 여행지가 존재하지 않습니다. id=" + dto.getSiteId()));
        return DetailPlanDto.toDto(detailPlanRepository.save(dto.toEntity(plan, site)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        detailPlanRepository.deleteById(id);
    }

    @Override
    public List<DetailPlanDto> listDetailPlan(Long planId) {
        return List.of();
    }
}
