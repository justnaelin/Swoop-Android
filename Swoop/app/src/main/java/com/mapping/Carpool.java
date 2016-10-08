package com.mapping;

/**
 * Created by ychino on 10/4/16.
 */

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "Carpool")
public class Carpool {

    //TODO: create startLocation and endLocation instance variables
    private String carpoolId;
    private String userId;
    private String timeStamp;
    private double rate;
    private int numberOfPassengers;
    private String carpoolStatus;
    private Boolean isCompleted;
    private Boolean isDeleted;

    @DynamoDBHashKey(attributeName="carpoolId")
    public String getId() { return carpoolId;}
    public void setId(String carpoolId) {this.carpoolId = carpoolId;}

    @DynamoDBAttribute(attributeName="userId")
    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}

    @DynamoDBAttribute(attributeName="timeStamp")
    public String getTimeStamp() {return timeStamp;}
    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}

    @DynamoDBAttribute(attributeName="rate")
    public double getRate() {return rate;}
    public void setRate(double rate) {this.rate = rate;}

    @DynamoDBAttribute(attributeName="numberOfPassengers")
    public int getNumberOfPassengers() {return numberOfPassengers;}
    public void setNumberOfPassengers(int numberOfPassengers) {this.numberOfPassengers = numberOfPassengers;}

    @DynamoDBAttribute(attributeName="carpoolStatus")
    public String getCarpoolStatus() {return carpoolStatus;}
    public void setCarpoolStatus(String carpoolStatus) {this.carpoolStatus = carpoolStatus;}

    @DynamoDBAttribute(attributeName="isCompleted")
    public Boolean getIsCompleted() {return isCompleted;}
    public void setIsCompleted(Boolean completed) {isCompleted = completed;}

    @DynamoDBAttribute(attributeName="isDeleted")
    public Boolean getIsDeleted() {return isDeleted;}
    public void setIsDeleted(Boolean deleted) {isDeleted = deleted;}

}
