package com.grouping.groupingserver.application.member.facade;

import com.grouping.groupingserver.api.dto.response.MemberResponse;
import com.grouping.groupingserver.application.member.command.OauthLoginCommand;
import com.grouping.groupingserver.application.member.service.MemberService;
import com.grouping.groupingserver.application.member.service.SocialAccountService;
import com.grouping.groupingserver.domain.member.entity.SocialAccount;
import com.grouping.groupingserver.domain.member.vo.OauthProvider;
import com.grouping.groupingserver.infrastructure.oauth.google.GoogleOAuthClient;
import com.grouping.groupingserver.infrastructure.oauth.google.GoogleTokenResponse;
import com.grouping.groupingserver.infrastructure.oauth.google.GoogleUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuthFacade {

    private final GoogleOAuthClient googleOAuthService;
    private final GoogleOAuthClient googleOAuthClient;
    private final SocialAccountService socialAccountService;
    private final MemberService memberService;
//    private final JwtTokenProvider jwtTokenProvider;

    public String loginWithGoogle(String code) {
        GoogleTokenResponse tokenResponse = googleOAuthClient.exchangeCodeForToken(code);
        log.info("GoogleTokenResponse? {}", tokenResponse.toString());
        String token = tokenResponse.accessToken();
        GoogleUser user = googleOAuthService.getUserInfo(token);
        log.info("googleUser? {}", user.toString());

        String id = user.sub();
        String email = user.email();
        String name = user.name();




        // JWT 발급
//            String token = jwtTokenProvider.generateToken(member.getId(), member.getRole());
//            return ResponseEntity.ok(Map.of("token", token));
        return "test_token";
    }
}
