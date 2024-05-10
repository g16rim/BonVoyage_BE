package com.ssafy.BonVoyage.group.domain;

import com.ssafy.BonVoyage.auth.domain.Member;
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

    @Column
    private Long groupId;

    public GroupWithMember(Member member, Long groupId) {
        this.member = member;
        this.groupId = groupId;
    }

}