package com.ssafy.BonVoyage.plan.controller;

import com.ssafy.BonVoyage.plan.dto.DetailPlanDto;
import com.ssafy.BonVoyage.plan.dto.response.DetailPlanListResponse;
import com.ssafy.BonVoyage.plan.service.DetailPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/detail/{planId}")
@RequiredArgsConstructor
@Tag(name ="Detail Plan", description = "여행 상세 계획 API")
@Slf4j
public class DetailPlanController {

    private final DetailPlanService detailPlanService;

    @Operation(summary = "상세 계획 등록", description = "plan_id, site_id, day, plan_order 등록")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "계획 생성 성공", content = { @Content(mediaType = "application/json") } ),
            @ApiResponse(responseCode = "400", description = "유저 확인 실패", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class) ) } ),
    })
    @PostMapping
    public ResponseEntity<?> regist(@RequestBody List<DetailPlanDto> plans) {
        log.info("등록 -> {}", plans.toArray().length);
        detailPlanService.create(plans);
        return ResponseEntity.ok(true);
    }

    @Operation(summary = "상세 계획 수정", description = "plan_order 수정")
    @PutMapping
    public ResponseEntity<?> update(@RequestBody List<DetailPlanDto> plans) {
        log.info("update controller");
        for (DetailPlanDto detailPlan : plans) {
            log.info("detailPlan = {}", detailPlan.toString());
        }
        detailPlanService.modifyOrder(plans);
        return ResponseEntity.ok(true);
    }

    @Operation(summary = "상세 계획 목록", description = "site - mapy, mapx, title, type이 필요")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "목록 조회 성공", content = { @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DetailPlanListResponse.class))) } ),
            @ApiResponse(responseCode = "400", description = "유저 확인 실패", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class) ) } ),
    })
    @GetMapping
    public ResponseEntity<?> list(@PathVariable int planId) {
        return ResponseEntity.ok(detailPlanService.listDetailPlanSites(planId));
    }
}
