package com.ssafy.BonVoyage.travelCommon.domain;

import com.ssafy.BonVoyage.login.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="group_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupWithMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_member_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private TravelGroup travelGroup;

    public GroupWithMember(Member member, TravelGroup travelGroup) {
        this.member = member;
        this.travelGroup = travelGroup;
    }

}