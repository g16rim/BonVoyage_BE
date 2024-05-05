package com.ssafy.BonVoyage.plan.dto;

import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
public class TravelPlanDto {
    private Long travelGroupId;
    private Date startDate;
    private Date endDate;
    private Timestamp timestamp;  // 여행 생성 날짜
    private Integer budget;
    private String planTitle;

    public TravelPlan toEntity(TravelGroup travelGroup) {
        return TravelPlan.builder()
                .startDate(startDate)
                .endDate(endDate)
                .timestamp(timestamp)
                .budget(budget)
                .planTitle(planTitle)
                .travelGroup(travelGroup)
                .build();
    }

    public static TravelPlanDto toDto(TravelPlan entity) {
        return TravelPlanDto.builder()
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .timestamp(entity.getTimestamp())
                .budget(entity.getBudget())
                .planTitle(entity.getPlanTitle())
                .travelGroupId(entity.getTravelGroup().getId())
                .build();
    }

}

