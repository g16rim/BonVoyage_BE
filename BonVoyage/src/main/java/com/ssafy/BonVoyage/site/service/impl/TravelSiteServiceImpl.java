package com.ssafy.BonVoyage.site.service.impl;

import com.ssafy.BonVoyage.site.dto.TravelSiteDto;
import com.ssafy.BonVoyage.site.repository.TravelSiteRepository;
import com.ssafy.BonVoyage.site.service.TravelSiteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TravelSiteServiceImpl implements TravelSiteService {

    private TravelSiteRepository travelSiteRepository;

    @Override
    public TravelSiteDto read(Long id) {
        return TravelSiteDto.toDto(travelSiteRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 여행지가 존재하지 않습니다. id=" + id)));
    }

}
