package com.booker.tests.auth;

import com.booker.base.service.AuthService;
import com.booker.model.request.LoginRequest;
import com.booker.model.response.TokenResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateToken {

    @Test
    public void createTokenFromAuth(){
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("admin","password123");

        Response response = authService.createToken(loginRequest);
        TokenResponse tokenResponse = response.as(TokenResponse.class);
        System.out.println(tokenResponse.getToken());
    }
}
