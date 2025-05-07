package com.grouping.groupingserver.domain.member;

import com.grouping.groupingserver.domain.member.entity.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository {
    Optional<Member> findById(UUID id);
}
