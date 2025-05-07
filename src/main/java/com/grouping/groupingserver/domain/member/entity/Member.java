package com.grouping.groupingserver.domain.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Table(name = "member")
public class Member {
    @Id
    private UUID id;
    private String nickname;
    private String email;
    private String profileImage;
    @ColumnDefault("'ACTIVE'")
    private String status;
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Instant createdAt;
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Instant updatedAt;
}