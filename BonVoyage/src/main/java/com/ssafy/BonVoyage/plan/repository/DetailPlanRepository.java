package com.ssafy.BonVoyage.plan.repository;

import com.ssafy.BonVoyage.plan.domain.DetailPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailPlanRepository extends JpaRepository<DetailPlan, Long> {
}
