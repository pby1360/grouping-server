package com.grouping.groupingserver.application.member.facade;

import com.grouping.groupingserver.application.member.command.CreateMemberCommand;
import com.grouping.groupingserver.application.member.command.CreateSocialAccountCommand;
import com.grouping.groupingserver.application.member.dto.MemberDto;
import com.grouping.groupingserver.application.member.dto.SocialAccountDto;
import com.grouping.groupingserver.application.member.service.MemberService;
import com.grouping.groupingserver.application.member.service.SocialAccountService;
import com.grouping.groupingserver.domain.member.vo.OAuthProvider;
import com.grouping.groupingserver.infrastructure.oauth.google.GoogleOAuthClient;
import com.grouping.groupingserver.infrastructure.oauth.google.GoogleTokenResponse;
import com.grouping.groupingserver.infrastructure.oauth.google.GoogleUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        String profileImage = user.picture();

        MemberDto member;
        Optional<SocialAccountDto> optSocialAccount = Optional.ofNullable(socialAccountService.getSocialAccount(OAuthProvider.GOOGLE, id));

        if (optSocialAccount.isPresent()) {
            member = memberService.getMember(optSocialAccount.get().memberId());
        } else {
            member = memberService.createMember(new CreateMemberCommand(name, email, profileImage));
            socialAccountService.createSocialAccount(new CreateSocialAccountCommand(member.id(), OAuthProvider.GOOGLE, id, tokenResponse.accessToken(), tokenResponse.refreshToken()));
        }

        // JWT 발급
//            String token = jwtTokenProvider.generateToken(member.getId(), member.getRole());
            return member.toString();
    }
}
