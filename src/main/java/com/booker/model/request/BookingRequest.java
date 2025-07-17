package com.booker.model.request;

public class BookingRequest {
    private String firstname;

    @Override
    public String toString() {
        return "BookingRequest{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", depositpaid=" + depositpaid +
                ", totalprice=" + totalprice +
                ", additionalneeds='" + additionalneeds + '\'' +
                ", bookingdates=" + bookingdates +
                '}';
    }

    public BookingRequest() {
    }

    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    private BookingRequest(String firstname, String lastname, boolean depositpaid, int totalprice, String additionalneeds, BookingDates bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositpaid = depositpaid;
        this.totalprice = totalprice;
        this.additionalneeds = additionalneeds;
        this.bookingdates = bookingdates;
    }

    private boolean depositpaid;
    private int totalprice;
    private String additionalneeds;
    private BookingDates bookingdates;

    public static class Builder{
        private String firstname;
        private String lastname;
        private boolean depositpaid;
        private int totalprice;
        private String additionalneeds;
        private BookingDates bookingdates;

        public Builder setFirstname(String firstname){
            this.firstname = firstname;
            return this;
        }
        public Builder setLastName(String lastname){
            this.lastname = lastname;
            return this;
        }
        public Builder setDepositPaid(Boolean depositpaid){
            this.depositpaid = depositpaid;
            return this;
        }
        public Builder setTotalPrice(int totalprice){
            this.totalprice = totalprice;
            return this;
        }
        public Builder setAdditionalNeeds(String additionalneeds){
            this.additionalneeds = additionalneeds;
            return this;
        }
        public Builder setBookingDates(BookingDates bookingdates){
            this.bookingdates = bookingdates;
            return this;
        }
        public BookingRequest build(){
            return new BookingRequest(firstname,lastname,depositpaid,totalprice,additionalneeds,bookingdates);
        }
    }
}
