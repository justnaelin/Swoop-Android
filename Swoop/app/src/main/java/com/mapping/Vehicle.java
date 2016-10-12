package com.mapping;

/**
 * Created by ychino on 10/6/16.
 */
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

@DynamoDBTable(tableName = "Vehicle")
public class Vehicle {

    private String userId;
    private String licensePlate;
    private String model;
    private String make;
    private String color;
    private int seats;

    @DynamoDBHashKey(attributeName="userId")
    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}

    @DynamoDBHashKey(attributeName="licensePlate")
    public String getLicensePlate() {return licensePlate;}
    public void setLicensePlate(String licensePlate) {this.licensePlate = licensePlate;}

    @DynamoDBAttribute(attributeName="model")
    public String getModel() {return model;}
    public void setModel(String timeStamp) {this.model = model;}

    @DynamoDBAttribute(attributeName="make")
    public String getMake() {return make;}
    public void setMake(String make) {this.make = make;}

    @DynamoDBAttribute(attributeName="color")
    public String getColor() {return color;}
    public void setColor(String carpoolStatus) {this.color = color;}

    @DynamoDBAttribute(attributeName="seats")
    public int getSeats() {return seats;}
    public void setSeats(int seats) {this.seats = seats;}

}
