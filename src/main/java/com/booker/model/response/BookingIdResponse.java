package com.booker.model.response;

import java.util.Arrays;
import java.util.List;

public class BookingIdResponse {
    int bookingid;

    public BookingIdResponse() {
    }

    @Override
    public String toString() {
        return "BookingIdResponse{" +
                "bookingid=" + bookingid +
                '}';
    }

    public int getBookingid() {
        return bookingid;
    }

    public BookingIdResponse(int bookingid) {
        this.bookingid = bookingid;
    }
}
