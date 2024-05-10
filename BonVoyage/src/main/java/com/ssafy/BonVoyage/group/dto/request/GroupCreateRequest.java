package com.ssafy.BonVoyage.group.dto.request;


import jakarta.annotation.Nullable;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public record GroupCreateRequest(
        @NotNull(message = "이름을 입력해주세요.")
        String name,

        @Nullable
        String description
) {
}