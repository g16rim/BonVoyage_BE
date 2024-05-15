package com.ssafy.BonVoyage.plan.service;

import com.ssafy.BonVoyage.plan.dto.TravelPlanDto;

public interface TravelPlanService {
//    List<TravelPlanDto> listPlan() TODO: 그룹별 조회
    Long create(TravelPlanDto dto);
    TravelPlanDto read(Long id);
    TravelPlanDto update(Long planId, TravelPlanDto dto);
    void delete(Long id);
}
