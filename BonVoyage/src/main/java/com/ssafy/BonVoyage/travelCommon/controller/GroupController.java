package com.ssafy.BonVoyage.travelCommon.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@Tag(name="Travel Group", description = "여행 그룹 CRUD")
@RequestMapping("/api")
public class GroupController {

}
