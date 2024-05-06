package com.ssafy.BonVoyage.plan.repository;

import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPlanRepository extends JpaRepository<TravelPlan, Long> {
}
