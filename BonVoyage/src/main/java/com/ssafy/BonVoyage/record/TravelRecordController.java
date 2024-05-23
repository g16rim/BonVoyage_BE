package com.ssafy.BonVoyage.record;

import com.ssafy.BonVoyage.auth.config.security.token.CurrentUser;
import com.ssafy.BonVoyage.auth.config.security.token.UserPrincipal;
import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.auth.repository.MemberRepository;
import com.ssafy.BonVoyage.plan.dto.TravelPlanDto;
import com.ssafy.BonVoyage.plan.repository.TravelPlanRepository;
import com.ssafy.BonVoyage.record.dto.TravelRecordDto;
import com.ssafy.BonVoyage.record.service.impl.TravelRecordServiceImpl;
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
@RequestMapping("/api/record")
@RequiredArgsConstructor
@Tag(name="Travel Record", description = "여행 기록 API")
public class TravelRecordController {

    private final TravelRecordServiceImpl travelRecordService;
    private final MemberRepository memberRepository;

    @Operation(summary = "여행 기록 생성", description = "여행 그룹이 기록을 시작합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "기록 생성 성공", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class) ) } ),
            @ApiResponse(responseCode = "400", description = "유저 확인 실패", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class) ) } ),
    })
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody TravelRecordDto dto, @CurrentUser UserPrincipal currentUser) {
        Member member = memberRepository.findById(currentUser.getId())
                .orElseThrow(() -> new IllegalStateException("해당 멤버는 존재하지 않습니다."));
        return new ResponseEntity<>(travelRecordService.create(dto, member), HttpStatus.CREATED);
    }

    @Operation(summary = "여행 기록 리스트", description = "자신의 여행 기록 리스트를 보여줍니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "기록 리스트 성공", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class) ) } ),
            @ApiResponse(responseCode = "400", description = "유저 확인 실패", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class) ) } ),
    })
    @GetMapping("/list")
    public ResponseEntity<?> list(@CurrentUser UserPrincipal currentUser) {
        return new ResponseEntity<>(travelRecordService.read(currentUser.getId()), HttpStatus.CREATED);
    }

}
