package com.ssafy.BonVoyage.site.service;

import com.ssafy.BonVoyage.site.dto.TravelSiteDto;
import org.springframework.stereotype.Service;

@Service
public interface TravelSiteService {
    public TravelSiteDto read(Long id);
}
