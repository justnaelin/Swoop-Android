package com.mapping;

/**
 * Created by ana perez on 10/7/16.
 * Summary: Address Mapper
 */

public class Address {

    private String street;
    private String city;
    private int userId;
    private String zipCode;

    public void setUserId(int userId) {this.userId = userId;}
    public int getUserId() {return userId;}

    public void setStreet(String street) {this.street = street;}
    public String getStreet() {return street;}

    public void setCity(String city) {this.city = city;}
    public String getCity() {return  city;}

    public void setZipCode(String zipCode) {this.zipCode = zipCode;}
    public String getZipCode() {return zipCode;}

    @Override
    public String toString() {
        return "Street: " + street + "\n"
                + "City: " + city + "\n"
                + "userID: "  + userId + "\n"
                + "zipcode: " + zipCode;
    }
}
