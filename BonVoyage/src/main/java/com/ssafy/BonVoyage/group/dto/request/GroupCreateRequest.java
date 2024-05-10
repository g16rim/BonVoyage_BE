package com.ssafy.BonVoyage.group.dto.request;


import jakarta.annotation.Nullable;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class GroupCreateRequest {

    @NotNull(message = "그룹 이름을 입력해주세요.")
    private String name;

    @Nullable
    private String description;
}
