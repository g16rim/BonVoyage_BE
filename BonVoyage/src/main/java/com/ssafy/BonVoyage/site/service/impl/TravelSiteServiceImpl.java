package com.ssafy.BonVoyage.site.service.impl;

import com.ssafy.BonVoyage.site.dto.TravelSiteDto;
import com.ssafy.BonVoyage.site.repository.TravelSiteRepository;
import com.ssafy.BonVoyage.site.service.TravelSiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TravelSiteServiceImpl implements TravelSiteService {

    private final TravelSiteRepository travelSiteRepository;

    @Override
    @Transactional(readOnly = true)
    public TravelSiteDto read(Long id) {
        return TravelSiteDto.toDto(travelSiteRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 여행지가 존재하지 않습니다. id=" + id)));
    }

}
