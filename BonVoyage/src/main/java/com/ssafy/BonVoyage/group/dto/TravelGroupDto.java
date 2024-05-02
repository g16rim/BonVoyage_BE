package com.ssafy.BonVoyage.group.dto;


import com.ssafy.BonVoyage.fileUpload.domain.ProfileImage;
import com.ssafy.BonVoyage.group.domain.GroupWithMember;
import com.ssafy.BonVoyage.group.enumeration.Preference;
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
