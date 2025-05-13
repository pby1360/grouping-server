package com.grouping.groupingserver.application.member.command;

import com.grouping.groupingserver.domain.member.vo.OAuthProvider;

public record OauthLoginCommand(
        String providerId,
        String name,
        String email,
        OAuthProvider provider
) {
}
