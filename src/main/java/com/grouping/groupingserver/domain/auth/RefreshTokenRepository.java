package com.grouping.groupingserver.domain.auth;

import com.grouping.groupingserver.domain.auth.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository {
    void save(RefreshToken tokenEntity);

    Optional<RefreshToken> findByToken(String refreshToken);

    void delete(RefreshToken token);
}
