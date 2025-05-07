package com.grouping.groupingserver.infrastructure.oauth.google;

public record GoogleUser(
        String sub,
        String email,
        String name,
        String picture
) {
}
