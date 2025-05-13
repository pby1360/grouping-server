package com.grouping.groupingserver.infrastructure.persistence.member;

import com.grouping.groupingserver.domain.member.MemberRepository;
import com.grouping.groupingserver.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class MemberJpaRepository implements MemberRepository {

    private final SpringDataMemberJpa jpa;

    @Override
    public Optional<Member> findById(UUID id) {
        return jpa.findById(id);
    }

    @Override
    public void save(Member member) {
        jpa.save(member);
    }
}
