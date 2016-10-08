package com.mapping;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by ana perez on 10/7/16.
 * Summary: Notification mapper for DynamoDB
 */

@DynamoDBTable(tableName = "Notification")
public class Notification {

    private String driverId;
    private String passengerId;
    private String notificationId;
    private String message;
    private String timeStamp;
    private String carpoolId;

    @DynamoDBHashKey(attributeName = "notificationId")
    public void setNotificationId(String notificationId) {this.notificationId = notificationId;}
    public String getNotificationId() {return notificationId;}

    @DynamoDBAttribute(attributeName = "driverId")
    public void setDriverId(String driverId) {this.driverId = driverId; }
    public String getDriverId() {return driverId; }

    @DynamoDBAttribute(attributeName = "passengerId")
    public void setPassengerId(String passengerId) {this.passengerId = passengerId;}
    public String getPassengerId() {return passengerId;}

    @DynamoDBAttribute(attributeName = "message")
    public void setMessage(String message) { this.message = message;}
    public String getMessage() {return message;}

    @DynamoDBAttribute(attributeName = "timeStamp")
    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}
    public String getTimeStamp() {return timeStamp;}

    @DynamoDBAttribute(attributeName = "carpoolId")
    public void setCarpoolId(String carpoolId) {this.carpoolId = carpoolId;}
    public String getCarpoolId() {return carpoolId;}
}
