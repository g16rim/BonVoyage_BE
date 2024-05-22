package com.ssafy.BonVoyage.plan.repository;

import com.ssafy.BonVoyage.plan.domain.DetailPlan;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailPlanRepository extends JpaRepository<DetailPlan, Long> {
    List<DetailPlan> findAllByTravelPlan(TravelPlan travelPlan);
    void deleteAllByTravelPlan(TravelPlan travelPlan);
}
