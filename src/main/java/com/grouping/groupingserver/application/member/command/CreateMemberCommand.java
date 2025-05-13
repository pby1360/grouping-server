package com.grouping.groupingserver.application.member.command;

import com.grouping.groupingserver.domain.member.vo.MemberStatus;

import java.util.UUID;

public record CreateMemberCommand(
        String nickname
        , String email
        , String profileImage
) {
}
