package com.ssafy.BonVoyage.plan.service;

import com.ssafy.BonVoyage.plan.dto.DetailPlanDto;

import java.util.List;

public interface DetailPlanService {
    int create(List<DetailPlanDto> dtos);
    DetailPlanDto read(Long id);
    DetailPlanDto update(DetailPlanDto dto);
    void delete(Long id);

    List<DetailPlanDto> listDetailPlan(Long planId);
}
