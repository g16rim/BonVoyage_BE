package com.ssafy.BonVoyage.plan.dto;

import com.ssafy.BonVoyage.plan.domain.DetailPlan;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class DetailPlanDto {
    private int day;
    private Timestamp time;
    private int planOrder;
    private Long travelPlanId;

    public DetailPlan toEntity(TravelPlan travelPlan) {
        return DetailPlan.builder()
                .day(day)
                .time(time)
                .planOrder(planOrder)
                .travelPlan(travelPlan)
                .build();
    }

    public static DetailPlanDto toDto(DetailPlan entity) {
        return DetailPlanDto.builder()
                .day(entity.getDay())
                .time(entity.getTime())
                .planOrder(entity.getPlanOrder())
                .travelPlanId(entity.getTravelPlan().getId())
                .build();
    }

}
