package com.ssafy.BonVoyage.plan.dto;

import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TravelPlanDto {
    private Long travelGroupId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer budget;
    private String planTitle;

    public TravelPlan toEntity(TravelGroup travelGroup) {
        return TravelPlan.builder()
                .startDate(startDate)
                .endDate(endDate)
                .budget(budget)
                .planTitle(planTitle)
                .travelGroup(travelGroup)
                .build();
    }

    public static TravelPlanDto toDto(TravelPlan entity) {
        return TravelPlanDto.builder()
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .budget(entity.getBudget())
                .planTitle(entity.getPlanTitle())
                .travelGroupId(entity.getTravelGroup().getId())
                .build();
    }

}

