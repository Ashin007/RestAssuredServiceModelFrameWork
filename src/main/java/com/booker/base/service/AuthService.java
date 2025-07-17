package com.booker.base.service;

import com.booker.base.BaseService;
import com.booker.model.request.LoginRequest;
import com.booker.utils.PropertiesFetcher;
import io.restassured.response.Response;

public class AuthService extends BaseService {

    private static final String AUTH_END_PONT = PropertiesFetcher.getPropertiesData("AUTH_END_PONT");

    public Response createToken(LoginRequest payload){
        return postRequest(payload,AUTH_END_PONT);
    }
}
