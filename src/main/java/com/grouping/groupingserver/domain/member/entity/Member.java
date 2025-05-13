package com.grouping.groupingserver.domain.member.entity;

import com.grouping.groupingserver.application.member.command.CreateMemberCommand;
import com.grouping.groupingserver.domain.member.vo.MemberStatus;
import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private MemberStatus status;
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Instant createdAt;
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Instant updatedAt;

    public static Member create(CreateMemberCommand command) {
        Member newMember = new Member();
        newMember.id = UUID.randomUUID();
        newMember.email = command.email();
        newMember.nickname = command.nickname();
        newMember.profileImage = command.profileImage();
        newMember.status = MemberStatus.ACTIVE;
        newMember.createdAt = Instant.now();
        newMember.updatedAt = Instant.now();
        return newMember;
    }
}