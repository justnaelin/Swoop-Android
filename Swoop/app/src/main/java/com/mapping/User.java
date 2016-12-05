package com.mapping;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
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
    private List<String> reviewIds;
    private String vehicleId;
    private String birthday;

    public User() {

    }

    public User(String responseBody) throws JSONException {
        JSONObject userJson = new JSONObject(responseBody);
        userId = userJson.getString("userId");
        firstName = userJson.getString("firstName");
        lastName = userJson.getString("lastName");
        emailAddress = userJson.getString("emailAddress");

        if(userJson.has("reviewIds")) {
            reviewIds = new ArrayList<>();
            JSONArray reviewIdsJson = userJson.getJSONArray("reviewIds");
            for (int i = 0; i < reviewIdsJson.length(); i++) {
                reviewIds.add(reviewIdsJson.get(i).toString());
            }
        }
        if(userJson.has("vehicleId")) {
            vehicleId = userJson.getString("vehicleId");
        }

        if(userJson.has("requestedCarpoolIds")) {
            requestedCarpoolIds = new ArrayList<>();
            JSONArray requestedCarpoolIdsJson = userJson.getJSONArray("requestedCarpoolIds");
            for (int i = 0; i < requestedCarpoolIdsJson.length(); i++) {
                reviewIds.add(requestedCarpoolIdsJson.get(i).toString());
            }
        }

        birthday = userJson.getString("birthday");
        address = userJson.getString("address");
        phoneNumber = userJson.getString("phoneNumber");

    }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "userID: " + userId + "\n"
                + "name: " + firstName + String.format("\nAverageRating: %s", averageRating) + "\n"
                + "lastName: " + lastName + "\n"
                + "phoneNumber: " + phoneNumber + "\n"
                + "emailAddress: " + emailAddress + "\n"
                + "requestedCarpoolIds: " + requestedCarpoolIds + "\n"
                + "reviewIds: " + reviewIds + "\n"
                + "vehicleID: " + vehicleId + "\n"
                + "address: " + address + "\n"
                + "birthday: " + birthday + "\n";
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
