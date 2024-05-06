package com.ssafy.BonVoyage.plan.controller;

import com.ssafy.BonVoyage.plan.dto.TravelPlanDto;
import com.ssafy.BonVoyage.plan.service.TravelPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("api/plan")
@RequiredArgsConstructor
public class TravelPlanController {

    private final TravelPlanService travelPlanService;

    @PostMapping("/{groupId}")
    public ResponseEntity<?> create(@PathVariable(name = "groupId") Long groupId, @RequestBody TravelPlanDto dto) {
        dto.setTravelGroupId(groupId);
        return new ResponseEntity<>(travelPlanService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{planId}")
    public ResponseEntity<?> read(@PathVariable(name = "planId") Long planId) {
        return ResponseEntity.ok(travelPlanService.read(planId));
    }

    @PutMapping("/{planId}")
    public ResponseEntity<?> update(@RequestBody TravelPlanDto dto) {
        return ResponseEntity.ok(travelPlanService.update(dto));
    }

    @DeleteMapping("/{planId}")
    public ResponseEntity<?> delete(@PathVariable(name = "planId") Long planId) {
        travelPlanService.delete(planId);
        return ResponseEntity.ok(planId);
    }

}
