package com.grouping.groupingserver.infrastructure.persistence.auth;

import com.grouping.groupingserver.domain.auth.RefreshTokenRepository;
import com.grouping.groupingserver.domain.auth.entity.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RefreshTokenJpaRepository implements RefreshTokenRepository {

    private final SpringDataRefreshTokenJpa jpa;

    @Override
    public void save(RefreshToken tokenEntity) {
        jpa.save(tokenEntity);
    }

    @Override
    public Optional<RefreshToken> findByToken(String refreshToken) {
        return jpa.findByToken(refreshToken);
    }

    @Override
    public void delete(RefreshToken token) {
        jpa.delete(token);
    }
}
