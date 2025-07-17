package com.booker.tests.booking;

import com.booker.base.service.AuthService;
import com.booker.base.service.BookingService;
import com.booker.model.request.LoginRequest;
import com.booker.model.response.BookingIdResponse;
import com.booker.model.response.TokenResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteBooking {

    private String token;
    private String bookingId;
    List<BookingIdResponse> booking;
    @Test(priority = 1)
    public void getTokenForBookingUpdate() {
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("admin", "password123");
        Response response = authService.createToken(loginRequest);
        response.prettyPrint();
        token = response.as(TokenResponse.class).getToken();
    }

    @Test(priority = 2)
    public void getListOfAllBookingId(){
        BookingService bookingService = new BookingService();
        Response bookingIdResponse =  bookingService.getAllBookingId();
        booking = bookingIdResponse.jsonPath().getList("", BookingIdResponse.class);
        for(int i=0;i<booking.size();i++){
            System.out.println(booking.get(i).getBookingid());
        }
        bookingId = String.valueOf(booking.get(booking.size()-1).getBookingid());
        System.out.println(bookingId);
    }

    @Test(priority = 3,dependsOnMethods = "getListOfAllBookingId")
    public void getBookingBeforeDelete(){
        BookingService bookingService = new BookingService();
        Response bookingIdInformation = bookingService.getBookingById(bookingId);
        bookingIdInformation.prettyPrint();

    }

    @Test(priority = 4,dependsOnMethods = {"getBookingBeforeDelete","getListOfAllBookingId"})
    public void deleteExistingBooking(){
        BookingService bookingService = new BookingService();
        Response response = bookingService.deleteBooking(token,bookingId);
        response.then().assertThat().statusCode(201);
        for(int i=0;i<booking.size();i++){
            System.out.println(booking.get(i).getBookingid());
            bookingService.deleteBooking(null,String.valueOf(booking.get(i).getBookingid()));
            System.out.println(booking.get(i).getBookingid()+" Deleted");
        }

    }
    @Test(priority = 5,dependsOnMethods = "deleteExistingBooking")
    public void getBookingAfterDelete(){
        BookingService bookingService = new BookingService();
        Response bookingIdInformation = bookingService.getBookingById(bookingId);
        bookingIdInformation.prettyPrint();

    }
}
