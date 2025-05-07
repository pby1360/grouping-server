package com.grouping.groupingserver.api.controller;

import com.grouping.groupingserver.application.member.facade.OAuthFacade;
import com.grouping.groupingserver.infrastructure.oauth.google.GoogleTokenResponse;
import com.grouping.groupingserver.infrastructure.oauth.google.GoogleUser;
import com.grouping.groupingserver.api.dto.response.MemberResponse;
import com.grouping.groupingserver.application.member.command.OauthLoginCommand;
import com.grouping.groupingserver.application.member.facade.MemberFacade;
import com.grouping.groupingserver.domain.member.vo.OauthProvider;
import com.grouping.groupingserver.infrastructure.oauth.google.GoogleOAuthClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/oauth")
@RequiredArgsConstructor
@Slf4j
public class OAuthController {

    private final OAuthFacade oAuthFacade;


    @PostMapping("/google")
    public ResponseEntity<?> loginWithGoogle(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        try {
            String token = oAuthFacade.loginWithGoogle(code);
            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid ID token");
        }
    }
}
