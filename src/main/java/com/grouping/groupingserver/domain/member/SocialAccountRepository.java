package com.grouping.groupingserver.domain.member;

import com.grouping.groupingserver.domain.member.entity.SocialAccount;

import java.util.Optional;

public interface SocialAccountRepository {
    Optional<SocialAccount> findByProviderAndProviderUserId(String provider, String providerUserId);
}
