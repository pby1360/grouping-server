package com.grouping.groupingserver.api.dto.request;

import com.grouping.groupingserver.domain.member.vo.OauthProvider;

public record OauthLoginRequest (String accessToken)
{}
