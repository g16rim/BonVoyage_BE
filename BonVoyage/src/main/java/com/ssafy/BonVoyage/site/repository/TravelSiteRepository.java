package com.ssafy.BonVoyage.site.repository;

import com.ssafy.BonVoyage.site.domain.TravelSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface TravelSiteRepository extends JpaRepository<TravelSite, Long> {
}
