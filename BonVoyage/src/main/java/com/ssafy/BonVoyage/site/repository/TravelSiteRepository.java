package com.ssafy.BonVoyage.site.repository;

import com.ssafy.BonVoyage.site.domain.TravelSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelSiteRepository extends JpaRepository<TravelSite, Long> {
    Optional<TravelSite> findById(Long id);
}
