package com.ssafy.BonVoyage.site.controller;

import com.ssafy.BonVoyage.site.dto.TravelSiteDto;
import com.ssafy.BonVoyage.site.service.TravelSiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel/site")
@RequiredArgsConstructor
@Tag(name = "Travel Site", description = "여행지 API")
public class TravelSiteController {

    private final TravelSiteService travelSiteService;

    @Operation(summary = "여행지 조회", description = "여행지 조회")
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable final Long id) {
        return ResponseEntity.ok(travelSiteService.read(id));
    }

    @Operation(summary = "contentid 배열 조회 후 저장", description = "contentid로 db 조회 후, 없으면 저장")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "여행지 조회&저장 성공", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class) ) } ),
            @ApiResponse(responseCode = "400", description = "유저 확인 실패", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class) ) } ),
    })
    @PostMapping
    public ResponseEntity<?> save(@RequestBody List<TravelSiteDto> sites) {
        travelSiteService.findAndSave(sites);
        return ResponseEntity.ok(true);
    }
    
}
