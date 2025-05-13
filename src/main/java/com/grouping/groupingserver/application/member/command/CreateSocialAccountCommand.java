package com.grouping.groupingserver.application.member.command;

import com.grouping.groupingserver.domain.member.vo.OAuthProvider;

import java.util.UUID;

public record CreateSocialAccountCommand(
        UUID memberId
        , OAuthProvider provider
        , String providerUserId
        , String accessToken
        , String refreshToken
) {
}
