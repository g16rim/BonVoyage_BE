package com.ssafy.BonVoyage.site.dto;

import com.ssafy.BonVoyage.site.domain.TravelSite;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TravelSiteDto {
    private Long id;
    private String name;
    private int type;
    private String sitePictureUrl;
    private String phone;
    private String content;
    private double rating;
    private int dibCount;
    private int reviewCount;
    private String operatingHours;
    private String closedDays;
    private double latitude;
    private double longitude;

    public static TravelSiteDto toDto(TravelSite entity) {
        return TravelSiteDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .sitePictureUrl(entity.getSitePictureUrl())
                .phone(entity.getPhone())
                .content(entity.getContent())
                .rating(entity.getRating())
                .dibCount(entity.getDibCount())
                .reviewCount(entity.getReviewCount())
                .operatingHours(entity.getOperatingHours())
                .closedDays(entity.getClosedDays())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }
}
