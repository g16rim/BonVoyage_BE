package com.ssafy.BonVoyage.plan.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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



}
