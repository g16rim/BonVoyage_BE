package com.ssafy.BonVoyage.plan.controller;

import com.ssafy.BonVoyage.plan.dto.DetailPlanDto;
import com.ssafy.BonVoyage.plan.service.DetailPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping
    public ResponseEntity<?> regist(@RequestBody List<DetailPlanDto> plans) {
        log.info("등록 -> {}", plans.toArray().length);
        detailPlanService.create(plans);
        return ResponseEntity.ok(true);
    }
}
