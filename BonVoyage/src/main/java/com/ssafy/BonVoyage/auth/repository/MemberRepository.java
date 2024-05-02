package com.ssafy.BonVoyage.auth.repository;


import com.ssafy.BonVoyage.auth.domain.Authority;
import com.ssafy.BonVoyage.auth.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
    int countByUsername(String username);

    List<Member> findAllByAuthority(Authority authority);
    boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query("update Member p set p.authority = :authority where p.id = :id")
    int updateAuthority(@Param("id") Long id, @Param("authority") Authority authority);

    Member findByBuildingAndFloor(int building, int floor);


    @Modifying
    @Transactional
    @Query("update Member m set m.imageUrl=:imageUrl where m.id=:id")
    void updateImageUrl(@Param("id") Long id, @Param("imageUrl") String imageUrl);
}
