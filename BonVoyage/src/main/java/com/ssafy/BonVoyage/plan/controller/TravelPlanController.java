package com.ssafy.BonVoyage.plan.controller;

import com.ssafy.BonVoyage.plan.dto.TravelPlanDto;
import com.ssafy.BonVoyage.plan.service.TravelPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plan")
@RequiredArgsConstructor
@Tag(name="Travel Plan", description = "여행 계획 API")
public class TravelPlanController {

    private final TravelPlanService travelPlanService;

    @Operation(summary = "여행 계획 생성", description = "여행 그룹이 계획을 시작합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "계획 생성 성공", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class) ) } ),
            @ApiResponse(responseCode = "400", description = "유저 확인 실패", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class) ) } ),
    })
    @PostMapping("/{groupId}")
    public ResponseEntity<?> create(@PathVariable(name = "groupId") Long groupId, @RequestBody TravelPlanDto dto) {
        dto.setTravelGroupId(groupId);
        return new ResponseEntity<>(travelPlanService.create(dto), HttpStatus.CREATED);
    }

    @Operation(summary = "여행 계획 조회", description = "여행 계획을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "계획 조회 성공", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TravelPlanDto.class) ) } ),
            @ApiResponse(responseCode = "400", description = "유저 확인 실패", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class) ) } ),
    })
    @GetMapping("/{planId}")
    public ResponseEntity<?> read(@PathVariable(name = "planId") Long planId) {
        return ResponseEntity.ok(travelPlanService.read(planId));
    }

    @Operation(summary = "여행 계획 수정", description = "여행 계획을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "계획 수정 성공", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = TravelPlanDto.class) ) } ),
            @ApiResponse(responseCode = "400", description = "유저 확인 실패", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class) ) } ),
    })
    @PutMapping("/{planId}")
    public ResponseEntity<?> update(@RequestBody TravelPlanDto dto) {
        return ResponseEntity.ok(travelPlanService.update(dto));
    }

    @Operation(summary = "여행 계획 삭제", description = "여행 계획을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "계획 삭제 성공", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class) ) } ),
            @ApiResponse(responseCode = "400", description = "유저 확인 실패", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class) ) } ),
    })
    @DeleteMapping("/{planId}")
    public ResponseEntity<?> delete(@PathVariable(name = "planId") Long planId) {
        travelPlanService.delete(planId);
        return ResponseEntity.ok(planId);
    }

}
