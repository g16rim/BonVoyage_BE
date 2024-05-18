package com.ssafy.BonVoyage.site.service.impl;

import com.ssafy.BonVoyage.site.domain.TravelSite;
import com.ssafy.BonVoyage.site.dto.TravelSiteDto;
import com.ssafy.BonVoyage.site.repository.TravelSiteRepository;
import com.ssafy.BonVoyage.site.service.TravelSiteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TravelSiteServiceImpl implements TravelSiteService {

    private final TravelSiteRepository travelSiteRepository;

    @Override
    @Transactional(readOnly = true)
    public TravelSiteDto read(Long id) {
        return TravelSiteDto.toDto(travelSiteRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 여행지가 존재하지 않습니다. id=" + id)));
    }

    @Override
    public void findAndSave(List<TravelSiteDto> sites) {
        for (TravelSiteDto site : sites) {
            if (!travelSiteRepository.existsById(site.getId())) {
                travelSiteRepository.save(site.toEntity());
                log.info("저장됐을까?");
            }
        }
    }

}
