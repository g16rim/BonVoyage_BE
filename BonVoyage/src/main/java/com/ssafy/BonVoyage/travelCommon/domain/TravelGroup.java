package com.ssafy.BonVoyage.travelCommon.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.BonVoyage.fileUpload.domain.ProfileImage;
import com.ssafy.BonVoyage.travelCommon.dto.TravelGroupDto;
import com.ssafy.BonVoyage.travelCommon.enumeration.Preference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;


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
    private Integer groupNum;

    @Enumerated(EnumType.STRING)
    private Preference preference;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "profileImage_id")
    private ProfileImage groupProfileImage;

    @OneToMany(mappedBy = "travelGroup")
    private List<GroupWithMember> groupWithMembers = new ArrayList<>();


    public static TravelGroup toEntity(TravelGroupDto dto) {
        return TravelGroup.builder()
                .groupName(dto.getGroupName())
                .groupNum(dto.getGroupNum())
                .preference(dto.getPreference())
                .groupProfileImage(dto.getGroupProfileImage())
                .build();
    }

}
