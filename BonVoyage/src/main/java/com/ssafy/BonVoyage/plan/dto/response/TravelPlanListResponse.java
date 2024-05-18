package com.ssafy.BonVoyage.plan.dto.response;

import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TravelPlanListResponse {
    Long groupId;
    String groupName;

    Long planId;
    String planTitle;
    LocalDate startDate;
    LocalDate endDate;
    Integer budget;

    public static TravelPlanListResponse toDto(TravelGroup group, TravelPlan plan) {
        return TravelPlanListResponse.builder()
                .groupId(group.getId())
                .groupName(group.getGroupName())
                .planId(plan.getId())
                .planTitle(plan.getPlanTitle())
                .startDate(plan.getStartDate())
                .endDate(plan.getEndDate())
                .budget(plan.getBudget())
                .build();
    }
}
