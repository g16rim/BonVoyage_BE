package com.ssafy.BonVoyage.travelCommon.service;

import com.ssafy.BonVoyage.login.domain.Member;
import com.ssafy.BonVoyage.travelCommon.domain.TravelGroup;
import com.ssafy.BonVoyage.travelCommon.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public TravelGroup addGroup(TravelGroup sendNotificationDto, Member member) {
        return null;
    }
}
