package com.booker.tests.booking;

import com.booker.base.service.BookingService;
import com.booker.model.request.BookingDates;
import com.booker.model.request.BookingRequest;
import com.booker.model.response.BookingResponse;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateBooking {
    private String bookingId;
    @Test(priority = 1)
    public void createBookingForUser(){
        Faker faker = new Faker();
        BookingService bookingService = new BookingService();
        BookingRequest requestPayload = new BookingRequest.Builder().setFirstname(faker.name().firstName())
                        .setLastName(faker.name().lastName())
                                .setDepositPaid(faker.bool().bool())
                                        .setAdditionalNeeds(faker.howIMetYourMother().catchPhrase())
                                                .setTotalPrice(faker.number().randomDigit())
                                                        .setBookingDates(new BookingDates(faker.date().future(5, TimeUnit.DAYS).toString(),faker.date().future(8, TimeUnit.DAYS).toString()))
                                                                .build();
        Response bookingCreationResponse = bookingService.createBooking(requestPayload);
        bookingCreationResponse.prettyPrint();
        BookingResponse bookingResponse = bookingCreationResponse.as(BookingResponse.class);
        bookingId = String.valueOf(bookingResponse.getBookingid());
        System.out.println("Booking id created: "+bookingId);
    }
    @Test(priority = 2,dependsOnMethods = "createBookingForUser")
    public void getBookingInformationById(){
        BookingService bookingService = new BookingService();
        Response bookingIdInformation = bookingService.getBookingById(bookingId);
        bookingIdInformation.prettyPrint();

    }
}
