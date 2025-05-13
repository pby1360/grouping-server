package com.grouping.groupingserver.domain.member;

import com.grouping.groupingserver.domain.member.entity.SocialAccount;
import com.grouping.groupingserver.domain.member.vo.OAuthProvider;

import java.util.Optional;

public interface SocialAccountRepository {
    Optional<SocialAccount> findByProviderAndProviderUserId(OAuthProvider provider, String providerUserId);
    void save (SocialAccount socialAccount);
}
