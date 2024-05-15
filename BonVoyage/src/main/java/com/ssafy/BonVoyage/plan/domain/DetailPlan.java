package com.ssafy.BonVoyage.plan.domain;

import com.ssafy.BonVoyage.site.domain.TravelSite;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "detail_plan")
public class DetailPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_plan_id")
    private Long id;

    @Column
    private int day;

    @Column
    private int planOrder;

    @Column
    private int price;

    @Column
    private String comment;

    @OneToOne
    @JoinColumn(name = "site_id")
    private TravelSite travelSite;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private TravelPlan travelPlan;

}
