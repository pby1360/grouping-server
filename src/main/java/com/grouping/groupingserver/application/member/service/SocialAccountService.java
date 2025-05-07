package com.grouping.groupingserver.application.member.service;

import com.grouping.groupingserver.domain.member.SocialAccountRepository;
import com.grouping.groupingserver.domain.member.entity.SocialAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialAccountService {

    private final SocialAccountRepository repository;

    public SocialAccount getSocialAccount (String provider, String providerUserId) {
        return repository.findByProviderAndProviderUserId(provider, providerUserId).orElseThrow();
    }
}
