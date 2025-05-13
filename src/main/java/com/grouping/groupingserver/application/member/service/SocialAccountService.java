package com.grouping.groupingserver.application.member.service;

import com.grouping.groupingserver.application.member.command.CreateSocialAccountCommand;
import com.grouping.groupingserver.application.member.dto.SocialAccountDto;
import com.grouping.groupingserver.domain.member.SocialAccountRepository;
import com.grouping.groupingserver.domain.member.entity.SocialAccount;
import com.grouping.groupingserver.domain.member.vo.OAuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocialAccountService {

    private final SocialAccountRepository repository;

    public SocialAccountDto getSocialAccount (OAuthProvider oAuthProvider, String providerUserId) {
        return repository.findByProviderAndProviderUserId(oAuthProvider, providerUserId).map(SocialAccountDto::toDto).orElse(null);
    }

    public void createSocialAccount (CreateSocialAccountCommand command) {
        SocialAccount newSocialAccount = SocialAccount.create(command);
        repository.save(newSocialAccount);
    }
}
