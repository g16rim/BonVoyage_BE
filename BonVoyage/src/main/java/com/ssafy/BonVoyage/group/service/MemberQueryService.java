package com.ssafy.BonVoyage.group.service;

import com.ssafy.BonVoyage.group.dto.response.GroupReferenceResponse;
import com.ssafy.BonVoyage.group.repository.TravelGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryService {

    private final TravelGroupRepository groupRepository;

    public List<GroupReferenceResponse> findMyTeams(final Long memberId) {
        return groupRepository.findAllByMemberId(memberId)
                .stream()
                .map(GroupReferenceResponse::from)
                .toList();
    }
}
