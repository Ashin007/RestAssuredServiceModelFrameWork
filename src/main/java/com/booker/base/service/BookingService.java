package com.booker.base.service;

import com.booker.base.BaseService;
import com.booker.model.request.BookingRequest;
import com.booker.utils.PropertiesFetcher;
import io.restassured.response.Response;

public class BookingService extends BaseService {
    private static final String BOOKING_END_POINT = PropertiesFetcher.getPropertiesData("BOOKING_END_POINT");

    public Response getAllBookingId(){
        return getRequest(BOOKING_END_POINT);
    }
    public Response getBookingById(String id){
        return getRequest(BOOKING_END_POINT+"/"+id);
    }

    public Response createBooking(BookingRequest payload){
        return postRequest(payload,BOOKING_END_POINT);
    }
    public Response updateBooking(Object payload,String token,String id){
        return putRequest(payload,BOOKING_END_POINT+"/"+id,token);
    }
    public Response partiallyUpdateBooking(String token,Object payload,String id){
        return patchRequest(token,payload,BOOKING_END_POINT+"/"+id);
    }
    public Response deleteBooking(String token,String id){
        return deleteRequest(token,BOOKING_END_POINT+"/"+id);
    }
}
