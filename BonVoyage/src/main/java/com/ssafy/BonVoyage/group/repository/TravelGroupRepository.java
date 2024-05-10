package com.ssafy.BonVoyage.group.repository;

import com.ssafy.BonVoyage.group.domain.TravelGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TravelGroupRepository extends JpaRepository<TravelGroup, Long> {

    @Query("select t from TravelGroup t join GroupWithMember mt on mt.id=t.id where mt.member.id=:memberId")
    List<TravelGroup> findAllByMemberId(final Long memberId);

}
