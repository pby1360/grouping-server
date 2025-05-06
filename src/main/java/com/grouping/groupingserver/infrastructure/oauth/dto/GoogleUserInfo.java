package com.grouping.groupingserver.infrastructure.oauth.dto;

public record GoogleUserInfo(
        String id,
        String email,
        String name,
        String picture
) {
}
