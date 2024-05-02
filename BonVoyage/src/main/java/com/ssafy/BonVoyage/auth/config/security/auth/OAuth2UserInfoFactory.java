package com.ssafy.BonVoyage.auth.config.security.auth;



import com.ssafy.BonVoyage.auth.advice.assertThat.DefaultAssert;
import com.ssafy.BonVoyage.auth.config.security.auth.provider.Google;
import com.ssafy.BonVoyage.auth.config.security.auth.provider.Kakao;
import com.ssafy.BonVoyage.auth.config.security.auth.provider.Naver;
import com.ssafy.BonVoyage.auth.domain.Provider;

import java.util.Map;

public class OAuth2UserInfoFactory {
    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(Provider.google.toString())) {
            return new Google(attributes);
        } else if (registrationId.equalsIgnoreCase(Provider.naver.toString())) {
            return new Naver(attributes);
        } else if (registrationId.equalsIgnoreCase(Provider.kakao.toString())) {
            return new Kakao(attributes);
        } else {
            DefaultAssert.isAuthentication("해당 oauth2 기능은 지원하지 않습니다.");
        }
        return null;
    }
}
