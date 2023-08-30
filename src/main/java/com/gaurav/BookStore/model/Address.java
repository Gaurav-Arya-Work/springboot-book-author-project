package com.gaurav.BookStore.model;


public class Address {
    private String houseNo;
    private String city;
    private String state;

    public Address(String houseNo, String city, String state) {
        this.houseNo = houseNo;
        this.city = city;
        this.state = state;
    }

    public Address(){}
}
