package com.booker.filters;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogFilters implements Filter {
    private static final Logger logger = LogManager.getLogger(LogFilters.class);
    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
        logResponse(response);
        return response;
    }
    public void logRequest(FilterableRequestSpecification filterableRequestSpecification){
        logger.info("BASE URI: "+filterableRequestSpecification.getBaseUri());
        logger.info("Request Header: "+filterableRequestSpecification.getHeaders());
        logger.info("Request Payload: "+filterableRequestSpecification.getBody());
    }
    public void logResponse(Response response){
        logger.info("Status Code: "+response.statusCode());
        logger.info("Headers: "+response.headers());
        logger.info("Request Body: "+response.prettyPrint());
    }
}
