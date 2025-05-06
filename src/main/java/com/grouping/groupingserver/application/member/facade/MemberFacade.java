package com.grouping.groupingserver.application.member.facade;

import com.grouping.groupingserver.api.dto.response.MemberResponse;
import com.grouping.groupingserver.application.member.command.OauthLoginCommand;
import com.grouping.groupingserver.application.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
//@Transactional
public class MemberFacade {

    private final MemberService memberService;

    public MemberResponse loginOrRegister(OauthLoginCommand login) {
//        Member member = memberService.registerOrGet(
//                request.oauthId(),
//                request.provider(),
//                request.nickname()
//        );
//        return MemberResponse.from(member);
        return new MemberResponse(1L, "bb17kor");
    }
}
