package com.ssafy.BonVoyage.travelCommon.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.BonVoyage.fileUpload.domain.ProfileImage;
import com.ssafy.BonVoyage.travelCommon.domain.GroupWithMember;
import com.ssafy.BonVoyage.travelCommon.enumeration.Preference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TravelGroupDto {

    private String groupName;

    private Integer groupNum;

    private Preference preference;

    private ProfileImage groupProfileImage;

    private List<GroupWithMember> groupWithMembers = new ArrayList<>();
}
