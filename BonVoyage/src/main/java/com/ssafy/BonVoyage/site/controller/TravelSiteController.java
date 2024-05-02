package com.ssafy.BonVoyage.site.controller;

import com.ssafy.BonVoyage.site.service.TravelSiteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/travel/site")
@RequiredArgsConstructor
@Tag(name = "travel site", description = "여행지 API")
public class TravelSiteController {

    private final TravelSiteService travelSiteService;


}
