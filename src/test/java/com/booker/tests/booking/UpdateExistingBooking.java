package com.booker.tests.booking;

import com.booker.base.service.AuthService;
import com.booker.base.service.BookingService;
import com.booker.model.request.BookingDates;
import com.booker.model.request.BookingRequest;
import com.booker.model.request.LoginRequest;
import com.booker.model.response.BookingIdResponse;
import com.booker.model.response.TokenResponse;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class UpdateExistingBooking {

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
    }

    @Test(priority =2,dependsOnMethods = {"getTokenForBookingUpdate","getListOfAllBookingId"})
    public void updateExistingBooking() {

        Faker faker = new Faker();
        BookingService bookingService = new BookingService();
        BookingRequest bookingRequestPayload = new BookingRequest.Builder().setFirstname(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setTotalPrice(faker.number().randomDigit())
                .setDepositPaid(faker.bool().bool())
                .setBookingDates(new BookingDates("2018-01-01", "2019-01-01"))
                .setAdditionalNeeds(faker.howIMetYourMother().catchPhrase())
                .build();
        Response updatedBookingResponse = bookingService.updateBooking(bookingRequestPayload, token, bookingId);

        System.out.println("Content Type: "+updatedBookingResponse.contentType());
        if(updatedBookingResponse.contentType().equalsIgnoreCase("application/json; charset=utf-8")){
            BookingRequest bookingRequest = updatedBookingResponse.as(BookingRequest.class);
            System.out.println(bookingRequest.toString());
            System.out.println("Application/json");
        }
        else{
            updatedBookingResponse.then().assertThat().statusCode(200);
            System.out.println("Partial update: text/plain; charset=utf-8");
        }


    }
}