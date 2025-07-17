package com.booker.tests.booking;

import com.booker.base.service.BookingService;
import com.booker.model.response.BookingIdResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class GetBookingId {

    @Test
    public void getListOfAllBookingId(){
        BookingService bookingService = new BookingService();
        Response bookingIdResponse =  bookingService.getAllBookingId();
        List<BookingIdResponse> booking = bookingIdResponse.jsonPath().getList("", BookingIdResponse.class);
        System.out.println(booking.size());
//        for(BookingIdResponse bookingId:booking){
//            System.out.println(bookingId.getBookingid());
//        }
    }
}
