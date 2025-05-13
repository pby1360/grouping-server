package com.grouping.groupingserver.infrastructure.persistence.member;

import com.grouping.groupingserver.domain.member.entity.Member;
import com.grouping.groupingserver.domain.member.entity.SocialAccount;
import com.grouping.groupingserver.domain.member.vo.OAuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataSocialAccountJpa extends JpaRepository<SocialAccount, Long> {
    Optional<SocialAccount> findByProviderAndProviderUserId(OAuthProvider provider, String providerUserId);
}
