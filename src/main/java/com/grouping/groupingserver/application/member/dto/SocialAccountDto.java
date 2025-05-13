package com.grouping.groupingserver.application.member.dto;

import com.grouping.groupingserver.domain.member.entity.SocialAccount;
import com.grouping.groupingserver.domain.member.vo.OAuthProvider;

import java.time.Instant;
import java.util.UUID;

public record SocialAccountDto(
        Long id
        , UUID memberId
        , OAuthProvider provider
        , String providerUserId
        , String accessToken
        , String refreshToken
        , Instant connectedAt
) {
    public static SocialAccountDto toDto (SocialAccount entity) {
        return new SocialAccountDto(entity.getId(), entity.getMemberId(), entity.getProvider(), entity.getProviderUserId(), entity.getAccessToken(), entity.getRefreshToken(), entity.getConnectedAt());
    }
}
