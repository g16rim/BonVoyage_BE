package com.ssafy.BonVoyage.plan.domain;


import com.ssafy.BonVoyage.group.domain.TravelGroup;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    @CreatedDate
    private LocalDateTime createdDate;  // 여행 생성 날짜

    @Column
    private Integer budget;

    @Column
    private String planTitle;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private TravelGroup travelGroup;
}
