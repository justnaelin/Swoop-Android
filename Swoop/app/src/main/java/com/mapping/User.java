package com.mapping;

import java.util.List;

/**
 * Created by ana perez on 10/6/16.
 * Summary: User Mapper
 */

public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private double averageRating;
    private String phoneNumber;
    private List<String> requestedCarpoolIds;
    private List<String>  reviewIds;
    private String vehicleId;
    private String birthday;
    public User(String userId, String firstName, String lastName, String address, String emailAddress,
                Double averageRating, String phoneNumber, String birthday, List<String> requestedCarpoolIds, String vehicleId, List<String> reviewIds) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.averageRating = averageRating;
        this.birthday = birthday;
        this.requestedCarpoolIds = requestedCarpoolIds;
        this.vehicleId = vehicleId;
        this.reviewIds = reviewIds;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public void setUserId(String userId) {this.userId = userId;}
    public String getUserId() {return userId;}

    public void setName(String name) {this.firstName = name;}
    public String getName() {return firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getLastName() {return lastName; }

    public void emailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    public String getEmailAddress() {return emailAddress;}

    public void setAverageRating(double averageRating) {this.averageRating = averageRating;}
    public double getAverageRating() {return averageRating;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getPhoneNumber() {return phoneNumber;}

    public void setBirthday(String birthday) {this.birthday = birthday;}
    public String getBirthday() {return birthday;}

    @Override
    public String toString() {
        return  "userID: " + userId + "\n"
                + "name: " + firstName + String.format("\nAverageRating: %s", averageRating) + "\n"
                + "lastName: " + lastName + "\n"
                + "phoneNumber: "  + phoneNumber + "\n"
                + "emailAddress: " + emailAddress + "\n"
                + "requestedCarpoolIDS: " + requestedCarpoolIds + "\n"
                + "reviewIds: "  + reviewIds + "\n"
                + "vehicleID: " + vehicleId + "\n"
                + "address: "  + address + "\n"
                + "birthday: " + birthday +"\n";
    }

    public List<String> getRequestedCarpoolIds() {
        return requestedCarpoolIds;
    }

    public void setRequestedCarpoolIds(List<String> requestedCarpoolIds) {
        this.requestedCarpoolIds = requestedCarpoolIds;
    }

    public List<String> getReviewIds() {
        return reviewIds;
    }

    public void setReviewIds(List<String> reviewIds) {
        this.reviewIds = reviewIds;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}
