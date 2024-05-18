package com.ssafy.BonVoyage.plan.domain;

import com.ssafy.BonVoyage.site.domain.TravelSite;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "detail_plan")
public class DetailPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_plan_id")
    private Long id;

    @Column
    private int day;

    @Column(name = "plan_order")
    private int planOrder;

    @OneToOne
    @JoinColumn(name = "site_id")
    private TravelSite travelSite;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private TravelPlan travelPlan;

}
