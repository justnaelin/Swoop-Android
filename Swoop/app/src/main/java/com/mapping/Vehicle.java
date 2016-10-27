package com.mapping;
/**
 * Vehicle
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class Vehicle {

    private String userId;
    private String licensePlate;
    private String model;
    private String make;
    private String color;
    private int seats;

    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}

    public String getLicensePlate() {return licensePlate;}
    public void setLicensePlate(String licensePlate) {this.licensePlate = licensePlate;}

    public String getModel() {return model;}
    public void setModel(String timeStamp) {this.model = model;}

    public String getMake() {return make;}
    public void setMake(String make) {this.make = make;}

    public String getColor() {return color;}
    public void setColor(String carpoolStatus) {this.color = color;}

    public int getSeats() {return seats;}
    public void setSeats(int seats) {this.seats = seats;}

    @Override
    public String toString() {
        return  "userID: " + userId + "\n"
                + "licensePlate: " + licensePlate +  "\n"
                + "model: " + model + "\n"
                + "make: "  + make + "\n"
                + "color: " + color + "\n"
                + "seats: " + seats +"\n";
    }
}
