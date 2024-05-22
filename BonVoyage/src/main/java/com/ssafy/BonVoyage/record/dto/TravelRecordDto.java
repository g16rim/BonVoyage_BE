package com.ssafy.BonVoyage.record.dto;

import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.record.domain.TravelRecord;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TravelRecordDto {
    private String comment;
    private Long travelGroupId;
    private Long travelPlanId;

    public TravelRecord toEntity(TravelGroup travelGroup) {
        return TravelRecord.builder()
                .comment(comment)
                .travelGroup(travelGroup)
                .build();
    }

    public static TravelRecordDto toDto(TravelRecord entity) {
        return TravelRecordDto.builder()
                .comment(entity.getComment())
                .travelGroupId(entity.getTravelGroup().getId())
                .build();
    }
}
