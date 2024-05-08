package com.ssafy.BonVoyage.plan.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class DetailPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_plan_id")
    private Long id;

    @Column
    private int day;

    @Column
    private Timestamp time;

    @Column
    private int planOrder;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private TravelPlan travelPlan;

}
