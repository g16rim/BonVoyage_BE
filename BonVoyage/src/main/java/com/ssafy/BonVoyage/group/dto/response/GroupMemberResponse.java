package com.ssafy.BonVoyage.group.dto.response;

import com.ssafy.BonVoyage.auth.domain.Member;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupMemberResponse {
    String memberEmail;
    String memberName;

    public static GroupMemberResponse toDto(Member member) {
        return GroupMemberResponse.builder()
                .memberEmail(member.getEmail())
                .memberName(member.getUsername())
                .build();
    }
}
