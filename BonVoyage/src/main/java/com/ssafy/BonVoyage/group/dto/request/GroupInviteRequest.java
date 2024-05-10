package com.ssafy.BonVoyage.group.dto.request;

import jakarta.validation.constraints.NotBlank;

public record GroupInviteRequest(
        @NotBlank(message = "초대코드를 입력해주세요.")
        String code
) {
}