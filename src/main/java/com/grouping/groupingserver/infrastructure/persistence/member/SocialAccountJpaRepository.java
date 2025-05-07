package com.grouping.groupingserver.infrastructure.persistence.member;

import com.grouping.groupingserver.domain.member.MemberRepository;
import com.grouping.groupingserver.domain.member.SocialAccountRepository;
import com.grouping.groupingserver.domain.member.entity.Member;
import com.grouping.groupingserver.domain.member.entity.SocialAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SocialAccountJpaRepository implements SocialAccountRepository {

    private final SpringDataSocialAccountJpa jpa;

    @Override
    public Optional<SocialAccount> findByProviderAndProviderUserId(String provider, String providerUserId) {
        return jpa.findByProviderAndProviderUserId(provider, providerUserId);
    }
}
