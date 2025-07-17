package com.booker.model.response;

import com.booker.model.request.BookingRequest;

public class BookingResponse {
    private int bookingid;

    @Override
    public String toString() {
        return "BookingResponse{" +
                ", booking=" + booking +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public BookingRequest getBooking() {
        return booking;
    }

    public void setBooking(BookingRequest booking) {
        this.booking = booking;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public BookingResponse() {
    }

    public BookingResponse(int bookingid, BookingRequest booking, String additionalneeds) {
        this.bookingid = bookingid;
        this.booking = booking;
        this.additionalneeds = additionalneeds;
    }
    public BookingResponse(BookingRequest booking, String additionalneeds) {
        this.booking = booking;
        this.additionalneeds = additionalneeds;
    }

    private BookingRequest booking;
    private String additionalneeds;
}
