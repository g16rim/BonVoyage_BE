package com.ssafy.BonVoyage.group.repository;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.group.domain.GroupWithMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupWithMemberRepository extends JpaRepository<GroupWithMember, Long> {

    @Query("SELECT g.member FROM GroupWithMember g WHERE g.groupId = :groupId")
    List<Member> findMemberByGroupId(@Param("groupId") Long groupId);

    int countDistinctByGroupId(Long groupId);

}
