package com.booker.tests.ping;

import com.booker.base.service.PingService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CheckHealth {

    @Test
    public void checkApiHealth(){

        PingService pingService = new PingService();
        Response response = pingService.healthCheck();
        response.then().assertThat().statusCode(201);
    }
}
