package com.ssafy.BonVoyage.group.repository;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.group.domain.GroupWithMember;
import com.ssafy.BonVoyage.group.domain.TravelGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupWithMemberRepository extends JpaRepository<GroupWithMember, Long> {
    List<TravelGroup> findTravelGroupByMember(Member member);
}
