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
    @Query("update profileImg p set p.member = :member where p.id = :profileImgId")
    int updateGallery(@Param("profileImgId") Long profileImgId, @Param("member") Member member);

}
