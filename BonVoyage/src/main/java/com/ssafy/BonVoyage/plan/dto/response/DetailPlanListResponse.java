package com.ssafy.BonVoyage.plan.dto.response;

import com.ssafy.BonVoyage.plan.domain.DetailPlan;
import com.ssafy.BonVoyage.site.domain.TravelSite;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailPlanListResponse {
    // travel site
    String title;
    int areaCode;
    double latitude;
    double longitude;
    String address;
    int type;
    String image;
    // detail plan
    int day;
    int planOrder;

    public static DetailPlanListResponse toResponse(TravelSite site, DetailPlan detailPlan) {
        return DetailPlanListResponse.builder()
                .title(site.getTitle())
                .areaCode(site.getAreaCode())
                .latitude(site.getLatitude())
                .longitude(site.getLongitude())
                .address(site.getAddress())
                .type(site.getType())
                .image(site.getImage())
                .day(detailPlan.getDay())
                .planOrder(detailPlan.getPlanOrder())
                .build();
    }
}
