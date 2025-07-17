package com.booker.model.request;

public class PartialBookingResponse {

    private String firstname;

    @Override
    public String toString() {
        return "PartialBookingResponse{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

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

    public PartialBookingResponse() {
    }

    public PartialBookingResponse(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    private String lastname;


}
