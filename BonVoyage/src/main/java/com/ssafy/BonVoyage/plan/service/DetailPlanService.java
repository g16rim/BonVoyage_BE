package com.ssafy.BonVoyage.plan.service;

import com.ssafy.BonVoyage.plan.dto.DetailPlanDto;
import com.ssafy.BonVoyage.plan.dto.response.DetailPlanListResponse;

import java.util.List;

public interface DetailPlanService {
    int create(List<DetailPlanDto> dtos);
    DetailPlanDto read(Long id);
    DetailPlanDto update(DetailPlanDto dto);
    void delete(Long id);

    List<DetailPlanDto> listDetailPlan(Long planId);

    List<DetailPlanListResponse> listDetailPlanSites(int planId);

    void modifyOrder(List<DetailPlanDto> plans);
}
