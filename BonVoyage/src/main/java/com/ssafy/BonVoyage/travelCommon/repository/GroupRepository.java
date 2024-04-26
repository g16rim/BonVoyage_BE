package com.ssafy.BonVoyage.travelCommon.repository;

import com.ssafy.BonVoyage.travelCommon.domain.TravelGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<TravelGroup, Integer> {
}
