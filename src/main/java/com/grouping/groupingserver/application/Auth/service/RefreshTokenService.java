package com.grouping.groupingserver.application.Auth.service;

import com.grouping.groupingserver.domain.auth.RefreshTokenRepository;
import com.grouping.groupingserver.domain.auth.entity.RefreshToken;
import com.grouping.groupingserver.infrastructure.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    private final Duration REFRESH_TOKEN_VALIDITY = Duration.ofDays(7);

    public String generateRefreshToken(UUID userId) {
        String refreshToken = UUID.randomUUID().toString();
        RefreshToken tokenEntity = RefreshToken.create(userId, refreshToken, REFRESH_TOKEN_VALIDITY);
        refreshTokenRepository.save(tokenEntity);
        return refreshToken;
    }

    public String reissueAccessToken(String refreshToken) {
        RefreshToken token = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() -> new RuntimeException("Invalid refresh token"));

        if (token.isExpired()) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Refresh token expired");
        }

        return jwtTokenProvider.generateToken(token.getUserId(), List.of("ROLE_USER"));
    }
}
