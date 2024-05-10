package com.ssafy.BonVoyage.group.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.BonVoyage.file.domain.ProfileImage;
import com.ssafy.BonVoyage.group.dto.TravelGroupDto;
import com.ssafy.BonVoyage.group.enumeration.Preference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;


@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelGroup {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @Column
    private String groupName;

    @Column
    private String description;

    @Column
    private Integer groupNum;

    @Enumerated(EnumType.STRING)
    private Preference preference;

    @Column
    private String groupProfileImage;


    public static TravelGroup toEntity(TravelGroupDto dto) {
        return TravelGroup.builder()
                .groupName(dto.getGroupName())
                .groupNum(dto.getGroupNum())
                .preference(dto.getPreference())
                .groupProfileImage(dto.getGroupProfileImage())
                .build();
    }

}
