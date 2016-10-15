package com.mapping;

/**
 * Created by ana perez on 10/6/16.
 * Summary: User Mapper
 */


public class User {
    private String userId;
    private String name;
    private String lastName;
    private String emailAddress;
    private double averageRating;
    private String phoneNumber;
    private String birthday;

    public void setUserId(String userId) {this.userId = userId;}
    public String getUserId() {return userId;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

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
                + "name: " + name + String.format("\nAverageRating: %s", averageRating) + "\n"
                + "lastName: " + lastName + "\n"
                + "phoneNumber: "  + phoneNumber + "\n"
                + "emailAddress: " + emailAddress + "\n"
                + "birthday: " + birthday +"\n";
    }
}
