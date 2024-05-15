package com.ssafy.BonVoyage.plan.service;

import com.ssafy.BonVoyage.plan.dto.TravelPlanDto;

import java.util.List;

public interface TravelPlanService {
    Long create(TravelPlanDto dto);
    TravelPlanDto read(Long id);
    TravelPlanDto update(Long planId, TravelPlanDto dto);
    void delete(Long id);

    List<TravelPlanDto> list(String userEmail);
}
