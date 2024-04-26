package com.ssafy.BonVoyage.fileUpload.repository;



import com.ssafy.BonVoyage.fileUpload.domain.ProfileImage;
import com.ssafy.BonVoyage.login.domain.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {
    @Override
    List<ProfileImage> findAll();

    Optional<ProfileImage> findById(Long id);

    @Transactional
    @Modifying
    @Query("update profileImage p set p.member = :member where p.id = :profileImageId")
    int updateGallery(@Param("profileImageId") Long profileImageId, @Param("member") Member member);

}
