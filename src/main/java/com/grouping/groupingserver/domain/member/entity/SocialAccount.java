package com.grouping.groupingserver.domain.member.entity;

import com.grouping.groupingserver.application.member.command.CreateSocialAccountCommand;
import com.grouping.groupingserver.domain.member.vo.OAuthProvider;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Table(name = "social_account")
public class SocialAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "social_account_id_gen")
    @SequenceGenerator(name = "social_account_id_gen", sequenceName = "social_account_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "member_id", nullable = false)
    private UUID memberId;

    @Column(name = "provider", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private OAuthProvider provider;

    @Column(name = "provider_user_id", nullable = false, length = 100)
    private String providerUserId;

    @Column(name = "access_token", length = Integer.MAX_VALUE)
    private String accessToken;

    @Column(name = "refresh_token", length = Integer.MAX_VALUE)
    private String refreshToken;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "connected_at")
    private Instant connectedAt;

    public static SocialAccount create (CreateSocialAccountCommand command) {
        SocialAccount newSocialAccount = new SocialAccount();
        newSocialAccount.memberId = command.memberId();
        newSocialAccount.provider = command.provider();
        newSocialAccount.providerUserId = command.providerUserId();
        newSocialAccount.accessToken = command.accessToken();
        newSocialAccount.refreshToken = command.refreshToken();
        newSocialAccount.connectedAt = Instant.now();
        return newSocialAccount;
    }
}