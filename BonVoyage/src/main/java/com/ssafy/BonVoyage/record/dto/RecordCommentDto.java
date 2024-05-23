package com.ssafy.BonVoyage.record.dto;

import com.ssafy.BonVoyage.auth.domain.Member;
import lombok.Data;

@Data
public class RecordCommentDto {
    private String comment;
    private Member member;
    public RecordCommentDto(String comment, Member member) {
        this.comment = comment;
        this.member = member;
    }
}
