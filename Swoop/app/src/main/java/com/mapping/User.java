package com.mapping;

/**
 * Created by ana perez on 10/6/16.
 * Summary: User Mapper to DynamoDB
 */

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;


@DynamoDBTable(tableName = "User")
public class User {
    private String userId;
    private String name;
    private String lastName;
    private String emailAddress;
    private double averageRating;
    private String phoneNumber;
    private String birthday;

    @DynamoDBHashKey(attributeName="userId")
    public void setUserId(String userId) {this.userId = userId;}
    public String getUserId() {return userId;}

    @DynamoDBAttribute(attributeName="name")
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    @DynamoDBAttribute(attributeName="lastName")
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getLastName() {return lastName; }

    @DynamoDBAttribute(attributeName="emailAddress")
    public void emailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    public String getEmailAddress() {return emailAddress;}

    @DynamoDBAttribute(attributeName="averageRating")
    public void setAverageRating(double averageRating) {this.averageRating = averageRating;}
    public double getAverageRating() {return averageRating;}

    @DynamoDBAttribute(attributeName="phoneNumber")
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getPhoneNumber() {return phoneNumber;}

    @DynamoDBAttribute(attributeName="birthday")
    public void setBirthday(String birthday) {this.birthday = birthday;}
    public String getBirthday() {return birthday;}

}
