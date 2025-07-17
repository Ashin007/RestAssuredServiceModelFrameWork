package com.booker.tests.booking;

import com.booker.base.service.BookingService;
import com.booker.model.response.BookingIdResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class GetBookingById {

    private String bookingId;
    @Test(priority = 1)
    public void getListOfAllBookingId(){
        BookingService bookingService = new BookingService();
        Response bookingIdResponse =  bookingService.getAllBookingId();
        List<BookingIdResponse> booking = bookingIdResponse.jsonPath().getList("", BookingIdResponse.class);
        //System.out.println(booking.size());
//        for(BookingIdResponse bookingId:booking){
//            System.out.println(bookingId.getBookingid());
//        }
        bookingId = String.valueOf(booking.get(booking.size()-1).getBookingid());
    }
    @Test(priority = 2,dependsOnMethods = "getListOfAllBookingId")
    public void getBookingInformationById(){
        BookingService bookingService = new BookingService();
        Response bookingIdInformation = bookingService.getBookingById(bookingId);
        bookingIdInformation.prettyPrint();

    }
}
