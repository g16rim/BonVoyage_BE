package com.ssafy.BonVoyage.plan.repository;

import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {
    List<TravelPlan> findByTravelGroupIn(List<TravelGroup> groups);
    List<TravelPlan> findByTravelGroup(TravelGroup travelGroup);
}
