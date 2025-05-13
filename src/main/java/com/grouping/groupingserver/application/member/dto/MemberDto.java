package com.grouping.groupingserver.application.member.dto;

import com.grouping.groupingserver.domain.member.entity.Member;
import com.grouping.groupingserver.domain.member.vo.MemberStatus;

import java.time.Instant;
import java.util.UUID;

public record MemberDto(
        UUID id
        , String nickname
        , String email
        , String profileImage
        , MemberStatus status
        , Instant createdAt
        , Instant updatedAt
) {
    public static MemberDto toDto (Member entity) {
        return new MemberDto(entity.getId(), entity.getNickname(), entity.getEmail(), entity.getProfileImage(), entity.getStatus(), entity.getCreatedAt(), entity.getUpdatedAt());
    }
}
