package com.ssafy.BonVoyage.plan.dto;

import com.ssafy.BonVoyage.plan.domain.DetailPlan;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import com.ssafy.BonVoyage.site.domain.TravelSite;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailPlanDto {
    private int day;
    private int planOrder;

    private Long planId;
    private Long siteId;

    public DetailPlan toEntity(TravelPlan travelPlan, TravelSite travelSite) {
        return DetailPlan.builder()
                .day(day)
                .planOrder(planOrder)
                .travelPlan(travelPlan)
                .travelSite(travelSite)
                .build();
    }

    public static DetailPlanDto toDto(DetailPlan entity) {
        return DetailPlanDto.builder()
                .day(entity.getDay())
                .planOrder(entity.getPlanOrder())
                .planId(entity.getTravelPlan().getId())
                .siteId(entity.getTravelSite().getId())
                .build();
    }

    @Override
    public String toString() {
        return "DetailPlanDto{" +
                "day=" + day +
                ", planOrder=" + planOrder +
                ", planId=" + planId +
                ", siteId=" + siteId +
                '}';
    }
}
