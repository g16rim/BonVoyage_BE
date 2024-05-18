package com.ssafy.BonVoyage.site.service;

import com.ssafy.BonVoyage.site.dto.TravelSiteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TravelSiteService {
    TravelSiteDto read(Long id);
    void findAndSave(List<TravelSiteDto> sites);
}
