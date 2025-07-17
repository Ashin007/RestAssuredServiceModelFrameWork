package com.booker.base;

import com.booker.utils.PropertiesFetcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {

    private static final String BASE_URI = PropertiesFetcher.getPropertiesData("BASE_URI");
    private final RequestSpecification requestSpecification;

    public BaseService(){
        requestSpecification = given().baseUri(BASE_URI);
    }
    public Response postRequest(Object payload, String endPoint){
        return requestSpecification.contentType("application/json").body(payload).post(endPoint);
    }

    public Response getRequest(String endPoint){
        return requestSpecification.get(endPoint);
    }

    public Response putRequest(Object payload,String endPoint,String cookieToken){
        return requestSpecification.contentType("application/json").accept("application/json").cookie("token",cookieToken).body(payload).log().all().put(endPoint);
    }
    public Response patchRequest(String cookieToken,Object payLoad,String endPoint){
        return requestSpecification.contentType("application/json").accept("application/json").cookie("token",cookieToken).body(payLoad).log().all().patch(endPoint);
    }
    public Response deleteRequest(String token,String endPoint){
        return requestSpecification.contentType("application/json").cookie("token",token).log().all().delete(endPoint);
    }
}
