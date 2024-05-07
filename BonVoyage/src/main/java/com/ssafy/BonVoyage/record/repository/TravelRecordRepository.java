package com.ssafy.BonVoyage.record.repository;

import com.ssafy.BonVoyage.record.domain.TravelRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRecordRepository extends JpaRepository<TravelRecord, Long> {
}
