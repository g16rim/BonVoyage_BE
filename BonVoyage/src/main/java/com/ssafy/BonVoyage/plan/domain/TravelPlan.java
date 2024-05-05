package com.ssafy.BonVoyage.plan.domain;


import com.ssafy.BonVoyage.group.domain.TravelGroup;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelPlan {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long id;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private Timestamp timestamp;  // 여행 생성 날짜

    @Column
    private Integer budget;

    @Column
    private String planTitle;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private TravelGroup travelGroup;
}
