package com.ssafy.BonVoyage.group.dto.request;

import jakarta.validation.constraints.NotBlank;

public record GroupInviteRequest(
        @NotBlank(message = "이메일을 입력해주세요.")
        String email
) {
}