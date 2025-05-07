package com.grouping.groupingserver.application.member.facade;

import com.grouping.groupingserver.application.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@Transactional
public class MemberFacade {

    private final MemberService memberService;
}
