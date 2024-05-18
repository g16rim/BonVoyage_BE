package com.ssafy.BonVoyage.site.dto;

import com.ssafy.BonVoyage.site.domain.TravelSite;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TravelSiteDto {
    private Long id;
    private String title;
    private int type;
    private String image;
    private String tel;
    private String address;
    private double rating;
    private int dibCount;
    private int reviewCount;
    private double latitude;
    private double longitude;
    int areaCode;

    public TravelSite toEntity() {
        return TravelSite.builder()
                .id(id)
                .title(title)
                .type(type)
                .image(image)
                .tel(tel)
                .address(address)
                .rating(rating)
                .dibCount(dibCount)
                .reviewCount(reviewCount)
                .latitude(latitude)
                .longitude(longitude)
                .areaCode(areaCode)
                .build();
    }

    public static TravelSiteDto toDto(TravelSite entity) {
        return TravelSiteDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .type(entity.getType())
                .image(entity.getImage())
                .tel(entity.getTel())
                .address(entity.getAddress())
                .rating(entity.getRating())
                .dibCount(entity.getDibCount())
                .reviewCount(entity.getReviewCount())
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .areaCode(entity.getAreaCode())
                .build();
    }
}
