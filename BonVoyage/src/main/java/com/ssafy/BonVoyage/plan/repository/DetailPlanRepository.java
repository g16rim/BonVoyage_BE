package com.ssafy.BonVoyage.plan.repository;

import com.ssafy.BonVoyage.plan.domain.DetailPlan;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailPlanRepository extends JpaRepository<DetailPlan, Long> {
    List<DetailPlan> findAllByTravelPlan(TravelPlan travelPlan);
    void deleteAllByTravelPlan(TravelPlan travelPlan);

    @Modifying
    @Query("update DetailPlan dp set dp.planOrder = :planOrder where dp.travelSite.id = :siteId and dp.travelPlan.id = :planId")
    int updatePlanOrderByPlanIdAndSiteId(int planOrder, Long siteId, Long planId);
}
