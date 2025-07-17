package com.booker.base.service;

import com.booker.base.BaseService;
import com.booker.utils.PropertiesFetcher;
import io.restassured.response.Response;

public class PingService extends BaseService {

    private static final String HEALTH_END_POINT = PropertiesFetcher.getPropertiesData("HEALTH_END_POINT");

    public Response healthCheck(){
        return getRequest(HEALTH_END_POINT);
    }
}
