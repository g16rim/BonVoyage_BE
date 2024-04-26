package com.ssafy.BonVoyage.record.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.ssafy.BonVoyage.travelCommon.domain.TravelGroup;
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
public class TravelRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long id;

    @Column
    private String comment;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "group_id")
    private TravelGroup travelGroup;

}
