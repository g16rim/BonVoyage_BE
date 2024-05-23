package com.ssafy.BonVoyage.record.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.plan.domain.TravelPlan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "travel_record", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"group_id", "plan_id", "member_id"})
})
public class TravelRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long id;

    @Column
    private String comment;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "group_id")
    private TravelGroup travelGroup;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "plan_id")
    private TravelPlan travelPlan;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "member_id")
    private Member member;

}
