package com.ssafy.BonVoyage.record.repository;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.record.domain.TravelRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelRecordRepository extends JpaRepository<TravelRecord, Long> {


    List<TravelRecord> findAllByTravelGroup(TravelGroup travelGroup);


}
