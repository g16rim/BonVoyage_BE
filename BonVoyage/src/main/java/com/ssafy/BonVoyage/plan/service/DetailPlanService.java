package com.ssafy.BonVoyage.plan.service;

import com.ssafy.BonVoyage.plan.dto.DetailPlanDto;

public interface DetailPlanService {
    Long create(DetailPlanDto dto);
    DetailPlanDto read(Long id);
    DetailPlanDto update(DetailPlanDto dto);
    void delete(Long id);
}
