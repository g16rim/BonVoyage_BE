package com.ssafy.BonVoyage.record.dto;

import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import com.ssafy.BonVoyage.record.domain.TravelRecord;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor

public class TravelListRecordDto {
    private TravelPlan travelPlan;
    private TravelGroup travelGroup;
    private List<RecordCommentDto> travelRecords;

    public TravelListRecordDto(List<RecordCommentDto> travelRecords, TravelGroup travelGroup, TravelPlan travelPlan) {
        this.travelRecords = travelRecords;
        this.travelGroup = travelGroup;
        this.travelPlan = travelPlan;
    }
}
