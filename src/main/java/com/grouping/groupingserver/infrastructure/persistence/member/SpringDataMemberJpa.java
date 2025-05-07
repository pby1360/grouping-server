package com.grouping.groupingserver.infrastructure.persistence.member;

import com.grouping.groupingserver.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataMemberJpa extends JpaRepository<Member, UUID> {
    Optional<Member> findById(UUID id);
}
