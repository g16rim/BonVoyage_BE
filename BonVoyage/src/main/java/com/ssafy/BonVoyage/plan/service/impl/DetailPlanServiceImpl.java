package com.ssafy.BonVoyage.plan.service.impl;

import com.ssafy.BonVoyage.plan.domain.DetailPlan;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import com.ssafy.BonVoyage.plan.dto.DetailPlanDto;
import com.ssafy.BonVoyage.plan.dto.response.DetailPlanListResponse;
import com.ssafy.BonVoyage.plan.repository.DetailPlanRepository;
import com.ssafy.BonVoyage.plan.repository.TravelPlanRepository;
import com.ssafy.BonVoyage.plan.service.DetailPlanService;
import com.ssafy.BonVoyage.site.domain.TravelSite;
import com.ssafy.BonVoyage.site.repository.TravelSiteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DetailPlanServiceImpl implements DetailPlanService {

    private final DetailPlanRepository detailPlanRepository;
    private final TravelPlanRepository travelPlanRepository;
    private final TravelSiteRepository siteRepository;

    @Override
    @Transactional
    public int create(List<DetailPlanDto> dtos) {
        int count = 0;
        for (DetailPlanDto dto : dtos) {
            log.info("detail plan: {}", dto.toString());
            TravelPlan plan = travelPlanRepository.findById(dto.getPlanId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 계획이 존재하지 않습니다. id=" + dto.getPlanId()));
            TravelSite site = siteRepository.findById(dto.getSiteId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 여행지가 존재하지 않습니다. id=" + dto.getSiteId()));
            detailPlanRepository.save(dto.toEntity(plan, site));

            count++;
        }
        return count;
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
    @Transactional(readOnly = true)
    public List<DetailPlanDto> listDetailPlan(Long planId) {
        return List.of();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetailPlanListResponse> listDetailPlanSites(int planId) {
        List<DetailPlanListResponse> result = new ArrayList<>();
        TravelPlan plan = travelPlanRepository.findById((long) planId)
                .orElseThrow(() -> new IllegalArgumentException("해당 계획이 존재하지 않습니다. id=" + planId));
        List<DetailPlan> detailPlans = detailPlanRepository.findAllByTravelPlan(plan);
        for (DetailPlan detailPlan : detailPlans) {
            TravelSite site = siteRepository.findById(detailPlan.getTravelSite().getId())
                    .orElseThrow(() -> new IllegalArgumentException("잘못된 site id=" + detailPlan.getTravelPlan().getId()));
            result.add(DetailPlanListResponse.toResponse(site, detailPlan));
        }
        return result;
    }
}
