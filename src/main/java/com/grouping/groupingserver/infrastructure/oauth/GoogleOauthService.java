package com.grouping.groupingserver.infrastructure.oauth;

import com.google.gson.Gson;
import com.grouping.groupingserver.infrastructure.oauth.dto.GoogleUserInfo;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

@Service
public class GoogleOauthService {

    private static final String GOOGLE_USERINFO_URL = "https://www.googleapis.com/oauth2/v2/userinfo";

    public GoogleUserInfo getUserInfo(String accessToken) {
        try {
            URL url = new URL(GOOGLE_USERINFO_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new IllegalArgumentException("구글 인증 실패: " + responseCode);
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String response = in.lines().collect(Collectors.joining());
                Gson gson = new Gson();
                return gson.fromJson(response, GoogleUserInfo.class);
            }
        } catch (IOException e) {
            throw new RuntimeException("구글 인증 요청 중 오류 발생", e);
        }
    }
}
