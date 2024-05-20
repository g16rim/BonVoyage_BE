package com.ssafy.BonVoyage.group.controller;

import com.ssafy.BonVoyage.auth.config.security.token.CurrentUser;
import com.ssafy.BonVoyage.auth.config.security.token.UserPrincipal;
import com.ssafy.BonVoyage.group.dto.request.GroupCreateRequest;
import com.ssafy.BonVoyage.group.dto.request.GroupInviteRequest;
import com.ssafy.BonVoyage.group.dto.response.GroupInviteResponse;
import com.ssafy.BonVoyage.group.dto.response.GroupReferenceResponse;
import com.ssafy.BonVoyage.group.exception.GroupException;
import com.ssafy.BonVoyage.group.service.GroupService;
import com.ssafy.BonVoyage.group.service.MemberQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Validated
@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name="Travel Group", description = "여행 그룹 CRUD")
@RequestMapping("/api/teams")
public class GroupController {

    private final GroupService groupService;
    private final MemberQueryService teamQueryService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "그룹 생성", description = "생성자가 그룹장인 그룹 생성/ 멤버의 accessToken 필요")
    public ResponseEntity<Void> createTeam(
            @Valid @RequestPart final GroupCreateRequest request,
            @CurrentUser UserPrincipal userPrincipal,
            @RequestPart(value="file",required = false)  MultipartFile file
    ) throws IOException {

        groupService.createGroup(request, file, userPrincipal);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{teamId}")
    @Operation(summary = "그룹 수정", description = "그룹 이름, 설명 수정")
    public ResponseEntity<Void> updateTeam(
            @PathVariable final Long teamId,
            @RequestBody final GroupCreateRequest request
    ) throws GroupException {
        groupService.updateGroup(teamId, request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{teamId}/image")
    @Operation(summary = "그룹 이미지 수정", description = "그룹 대표 이미지 변경")
    public ResponseEntity<Void> updateTeamImage(
            @PathVariable final Long teamId,
            @RequestPart(required = false) final MultipartFile file
    ) throws GroupException, IOException {
        groupService.updateGroupImage(teamId, file);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{teamId}")
    @Operation(summary = "그룹 삭제", description = "그룹 삭제")
    public ResponseEntity<Void> deleteTeam(@PathVariable final Long teamId) throws GroupException {
        groupService.deleteGroup(teamId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{teamId}/invite")
    @Operation(summary = "그룹 코드 생성", description = "그룹원 추가를 위한 그룹 코드 생성")
    public ResponseEntity<GroupInviteResponse> generateTeamInviteCode(
            @PathVariable final Long teamId
    ) throws GroupException {
        final GroupInviteResponse teamInviteCodeResponse = groupService.generateInviteCode(teamId);
        return ResponseEntity.ok(teamInviteCodeResponse);
    }

    @PostMapping("/{teamId}/join")
    @Operation(summary = "그룹원 추가", description = "그룹 코드 확인으로 그룹원 추가")
    public ResponseEntity<Void> joinTeam(
            @PathVariable final Long teamId,
            @Valid @RequestBody final GroupInviteRequest request
    ) throws GroupException {
        groupService.joinTeam(teamId, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/members")
    @Operation(summary = "내가 속한 그룹 탐색", description = "내가 속한 그룹 모두 찾기")
    public ResponseEntity<List<GroupReferenceResponse>> getMyTeams( @CurrentUser UserPrincipal userPrincipal) {
        Long memberId = userPrincipal.getId();
        return ResponseEntity.ok(teamQueryService.findMyTeams(memberId));
    }
}