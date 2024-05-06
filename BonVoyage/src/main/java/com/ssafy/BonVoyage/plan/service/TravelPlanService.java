package com.ssafy.BonVoyage.plan.service;

import com.ssafy.BonVoyage.plan.dto.TravelPlanDto;

public interface TravelPlanService {
    Long create(TravelPlanDto dto);
    TravelPlanDto read(Long id);
    TravelPlanDto update(TravelPlanDto dto);
    void delete(Long id);
}
