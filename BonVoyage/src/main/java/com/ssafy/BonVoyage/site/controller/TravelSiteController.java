package com.ssafy.BonVoyage.site.controller;

import com.ssafy.BonVoyage.site.service.TravelSiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/travel/site")
@RequiredArgsConstructor
@Tag(name = "Travel Site", description = "여행지 API")
public class TravelSiteController {

    private final TravelSiteService travelSiteService;

    @GetMapping("/{id}")
    @Operation(summary = "여행지 조회", description = "여행지 조회")
    public ResponseEntity<?> read(@PathVariable final Long id) {
        return ResponseEntity.ok(travelSiteService.read(id));
    }
}
