package com.grouping.groupingserver.application.member.service;

import com.grouping.groupingserver.application.member.command.CreateMemberCommand;
import com.grouping.groupingserver.application.member.dto.MemberDto;
import com.grouping.groupingserver.domain.member.MemberRepository;
import com.grouping.groupingserver.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public MemberDto getMember (UUID id) {
        return repository.findById(id).map(MemberDto::toDto).orElse(null);
    }

    public MemberDto createMember (CreateMemberCommand command) {
        Member newMember = Member.create(command);
        repository.save(newMember);
        return MemberDto.toDto(newMember);
    }
}
