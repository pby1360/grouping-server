package com.grouping.groupingserver.domain.member.entity;

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

    @Size(max = 20)
    @NotNull
    @Column(name = "provider", nullable = false, length = 20)
    private String provider;

    @Size(max = 100)
    @NotNull
    @Column(name = "provider_user_id", nullable = false, length = 100)
    private String providerUserId;

    @Column(name = "access_token", length = Integer.MAX_VALUE)
    private String accessToken;

    @Column(name = "refresh_token", length = Integer.MAX_VALUE)
    private String refreshToken;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "connected_at")
    private Instant connectedAt;
}