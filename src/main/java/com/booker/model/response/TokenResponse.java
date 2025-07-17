package com.booker.model.response;

public class TokenResponse {
    private String token;

    @Override
    public String toString() {
        return "TokenResponse{" +
                "token='" + token + '\'' +
                '}';
    }

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public TokenResponse() {
    }
}
