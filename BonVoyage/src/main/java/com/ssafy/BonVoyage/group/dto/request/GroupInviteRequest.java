package com.ssafy.BonVoyage.group.dto.request;

import jakarta.validation.constraints.NotBlank;

public class GroupInviteRequest {
    @NotBlank(message = "그룹 초대 코드를 입력해주세요")
    private String code;

}
