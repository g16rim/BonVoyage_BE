package com.ssafy.BonVoyage.group.dto.request;


import com.ssafy.BonVoyage.auth.domain.Grade;
import com.ssafy.BonVoyage.group.enumeration.Preference;
import jakarta.annotation.Nullable;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public record GroupCreateRequest(
        @NotNull(message = "이름을 입력해주세요.")
        String name,

        @Nullable
        String description,



        @NotNull(message = "컨셉을 하나 선택해주세요.")
        Preference preference


) {
}