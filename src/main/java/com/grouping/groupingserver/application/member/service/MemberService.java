package com.grouping.groupingserver.application.member.service;

import com.grouping.groupingserver.domain.member.MemberRepository;
import com.grouping.groupingserver.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public Member getMember (UUID id) {
        return repository.findById(id).orElseThrow();
    }
}
