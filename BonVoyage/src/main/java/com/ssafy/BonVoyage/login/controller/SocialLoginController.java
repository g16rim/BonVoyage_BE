package com.ssafy.BonVoyage.login.controller;

/**
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@Tag(name="social", description = "소셜 로그인 API")
public class SocialLoginController {

    private final KakaoOauthService kakaoOauthService;
    private final CustomDefaultOAuth2UserService oAuth2UserService;


    @Operation(method = "get", summary = "카카오 소셜 로그인 API")
    @PostMapping("/kakao")
    public ResponseEntity<?> kakaoGetToken(@RequestParam Map<String, String> codeMap) {

        String code = codeMap.get("code");

        //Kakao Login 수행 과정
        String accessToken = kakaoOauthService.getKakaoAccessToken(code);
        KakaoDTO kakaoDTO = kakaoOauthService.createKakaoUser(accessToken);

        System.out.println("kakaoDTO.getEmail() = " + kakaoDTO.getEmail());
        //로그인한 카카오 이메일이 로컬 계정으로 등록되어있다면



    }
}
 */
