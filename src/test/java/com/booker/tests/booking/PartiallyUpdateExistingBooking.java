package com.booker.tests.booking;

import com.booker.base.service.AuthService;
import com.booker.base.service.BookingService;
import com.booker.model.request.BookingRequest;
import com.booker.model.request.LoginRequest;
import com.booker.model.request.PartialBookingResponse;
import com.booker.model.response.BookingIdResponse;
import com.booker.model.response.TokenResponse;
import com.github.javafaker.Faker;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class PartiallyUpdateExistingBooking {


    private String token;
    private String bookingId;
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
        List<BookingIdResponse> booking = bookingIdResponse.jsonPath().getList("", BookingIdResponse.class);
        bookingId = String.valueOf(booking.get(booking.size()-1).getBookingid());
        System.out.println(bookingId);
    }

    @Test(priority = 3,dependsOnMethods = {"getTokenForBookingUpdate","getListOfAllBookingId"})
    public void partiallyUpdateBooking(){

        Faker faker = new Faker();
        BookingService bookingService = new BookingService();
        PartialBookingResponse partialBookingResponse = new PartialBookingResponse(faker.name().firstName(),faker.name().lastName());
        Response partialUpdateResponse = bookingService.partiallyUpdateBooking(token,partialBookingResponse,bookingId);
        System.out.println("Content Type: "+partialUpdateResponse.contentType());
        if(partialUpdateResponse.contentType().equalsIgnoreCase("application/json; charset=utf-8")){
            BookingRequest response = partialUpdateResponse.as(BookingRequest.class);
            System.out.println(response.toString());
            System.out.println("Application/json");
        }
        else{
            partialUpdateResponse.then().assertThat().statusCode(200);
            System.out.println("Partial update: text/plain; charset=utf-8");
        }

    }
}
