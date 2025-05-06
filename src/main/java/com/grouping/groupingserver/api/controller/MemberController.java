package com.grouping.groupingserver.api.controller;

import com.grouping.groupingserver.api.dto.request.OauthLoginRequest;
import com.grouping.groupingserver.api.dto.response.MemberResponse;
import com.grouping.groupingserver.api.dto.response.TokenResponse;
import com.grouping.groupingserver.application.member.command.OauthLoginCommand;
import com.grouping.groupingserver.application.member.facade.MemberFacade;
import com.grouping.groupingserver.domain.member.vo.OauthProvider;
import com.grouping.groupingserver.infrastructure.oauth.GoogleOauthService;
import com.grouping.groupingserver.infrastructure.oauth.dto.GoogleUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
public class MemberController {

    private final MemberFacade memberFacade;
    private final GoogleOauthService googleOauthService;

    @PostMapping("/login/google")
    public ResponseEntity<TokenResponse> googleLogin(@RequestBody OauthLoginRequest request) {
        GoogleUserInfo userInfo = googleOauthService.getUserInfo(request.accessToken());
        MemberResponse member = memberFacade.loginOrRegister(new OauthLoginCommand(userInfo.id(), userInfo.name(), userInfo.email(), OauthProvider.GOOGLE));
//        String jwt = generateJwtToken(member);  // 직접 구현 필요
        String jwt = "temporary_token";  // 직접 구현 필요
        return ResponseEntity.ok(new TokenResponse(jwt));
    }
}
