package com.ssafy.BonVoyage.group.dto.response;


import com.ssafy.BonVoyage.group.domain.TravelGroup;
import com.ssafy.BonVoyage.group.enumeration.Preference;

public record GroupReferenceResponse(
        Long id,
        String name,
        String description,
        Preference preference,
        String imageUrl
) {
    public static GroupReferenceResponse from(final TravelGroup group) {
        return new GroupReferenceResponse(group.getId(), group.getGroupName(), group.getDescription(), group.getPreference(), group.getGroupProfileImage());
    }
}
