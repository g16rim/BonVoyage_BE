package com.ssafy.BonVoyage.file.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.BonVoyage.auth.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "profileImage")
@Table(name = "profileImage")
public class ProfileImage {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "profileImage_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "member_id")
    private Member member;


    @Builder
    public ProfileImage(Long id, String filePath, Member member) {
        this.id = id;
        this.filePath = filePath;
        this.member=member;
    }
}
