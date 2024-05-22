package com.ssafy.BonVoyage.group.dto.response;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.group.domain.TravelGroup;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupInfoResponse {
    String groupName;
    String preference;
    String description;
    String leader;
    int count;

    public static GroupInfoResponse toDto(TravelGroup group, Member member, int count) {
        return GroupInfoResponse.builder()
                .groupName(group.getGroupName())
                .preference(String.valueOf(group.getPreference()))
                .description(group.getDescription())
                .leader(member.getUsername())
                .count(count)
                .build();
    }
}
