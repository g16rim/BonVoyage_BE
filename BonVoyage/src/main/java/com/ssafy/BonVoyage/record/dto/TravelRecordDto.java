package com.ssafy.BonVoyage.record.dto;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import com.ssafy.BonVoyage.record.domain.TravelRecord;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TravelRecordDto {
    private String comment;
    private Long travelGroupId;
    private Long travelPlanId;
    private TravelRecord travelRecord;
    private Member member;

    public TravelRecord toEntity(TravelGroup travelGroup, TravelPlan travelPlan, Member member) {
        return TravelRecord.builder()
                .comment(comment)
                .travelGroup(travelGroup)
                .travelPlan(travelPlan)
                .member(member)
                .build();
    }


    public static TravelRecordDto toDto(TravelRecord entity, TravelRecord travelRecord, Member member) {
        return TravelRecordDto.builder()
                .comment(entity.getComment())
                .member(member)
                .travelRecord(travelRecord)
                .travelGroupId(entity.getTravelGroup().getId())
                .build();
    }

}
