package com.ssafy.BonVoyage.auth.service;



import com.ssafy.BonVoyage.auth.advice.assertThat.DefaultAssert;
import com.ssafy.BonVoyage.auth.config.security.auth.OAuth2UserInfo;
import com.ssafy.BonVoyage.auth.config.security.auth.OAuth2UserInfoFactory;
import com.ssafy.BonVoyage.auth.config.security.token.UserPrincipal;
import com.ssafy.BonVoyage.auth.domain.Authority;
import com.ssafy.BonVoyage.auth.domain.Member;
import com.ssafy.BonVoyage.auth.domain.Provider;
import com.ssafy.BonVoyage.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomDefaultOAuth2UserService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (Exception e) {
            DefaultAssert.isAuthentication(e.getMessage());
        }
        return null;
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
        DefaultAssert.isAuthentication(!oAuth2UserInfo.getEmail().isEmpty());

        Optional<Member> memberOptional = memberRepository.findByEmail(oAuth2UserInfo.getEmail());
        Member member;
        if(memberOptional.isPresent()) {
            member = memberOptional.get();
            DefaultAssert.isAuthentication(member.getProvider().equals(Provider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId())));
            member = updateExistingUser(member, oAuth2UserInfo);
        } else {
            member = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        }
        log.info("member = " + member);
        return UserPrincipal.create(member, oAuth2User.getAttributes());
    }

    private Member registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        log.info(" 로그인 로직 "  );
        Member member = Member.builder()
                .provider(Provider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))
                .username(oAuth2UserInfo.getName())
                .email(oAuth2UserInfo.getEmail())
                .authority(Authority.USER)
                .imageUrl(oAuth2UserInfo.getImageUrl())
                .build();

        return memberRepository.save(member);
    }

    private Member updateExistingUser(Member member, OAuth2UserInfo oAuth2UserInfo) {

        member.updateName(oAuth2UserInfo.getName());
        member.updateImageUrl(oAuth2UserInfo.getImageUrl());

        return memberRepository.save(member);
    }
}
