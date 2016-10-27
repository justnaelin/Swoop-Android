package com.mapping;

/**
 * Carpool
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class Carpool {

    //TODO: create startLocation and endLocation instance variables
    private String carpoolId;
    private String userId;
    private String requestDate;
    private String startLocation;
    private String endLocation;
    private double rate;
    private int numberOfPassengers;
    private CarpoolStatus carpoolStatus;
    private Boolean isCompleted;
    private Boolean isDeleted;
    private Boolean isDriver;

    public Carpool(){

    };
    public Carpool(String carpoolId, String userId, String startLocation, String endLocation, String requestDate,
                   double rate, int numberOfPassengers, CarpoolStatus carpoolStatus, boolean isDriver, boolean isCompleted, boolean isDeleted) {
        this.carpoolId = carpoolId;
        this.userId = userId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.requestDate = requestDate;
        this.rate = rate;
        this.numberOfPassengers = numberOfPassengers;
        this.carpoolStatus = carpoolStatus;
        this.isDriver = isDriver;
        this.isCompleted = isCompleted;
        this.isDeleted = isDeleted;
    }


    public String getId() { return carpoolId;}
    public void setId(String carpoolId) {this.carpoolId = carpoolId;}

    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}

    public String getTimeStamp() {return requestDate;}
    public void setTimeStamp(String requestDate) {this.requestDate = requestDate;}

    public String getStartLocation() {return startLocation;}
    public void setStartLocation(String startLocation) {this.startLocation = startLocation;}

    public String getEndLocation() {return endLocation;}
    public void setEndLocation(String endLocation) {this.endLocation = endLocation;}

    public double getRate() {return rate;}
    public void setRate(double rate) {this.rate = rate;}

    public int getNumberOfPassengers() {return numberOfPassengers;}
    public void setNumberOfPassengers(int numberOfPassengers) {this.numberOfPassengers = numberOfPassengers;}

    public CarpoolStatus getCarpoolStatus() {return carpoolStatus;}
    public void setCarpoolStatus(CarpoolStatus carpoolStatus) {this.carpoolStatus = carpoolStatus;}

    public Boolean getIsCompleted() {return isCompleted;}
    public void setIsCompleted(Boolean completed) {isCompleted = completed;}

    public Boolean getIsDeleted() {return isDeleted;}
    public void setIsDeleted(Boolean deleted) {isDeleted = deleted;}

    public Boolean getIsDriver() {return isDriver;}
    public void setIsDriver(Boolean isDriver) {this.isDriver = isDriver;}


    @Override
    public String toString() {
        return "carpoolID: " + carpoolId + "\n"
                + "userID: " + userId + "\n"
                + "requestDate: "  + requestDate + "\n"
                + "startLocation: " + startLocation + "\n"
                + "endLocation: " + endLocation +
                String.format("\nRate: %s", rate) + "\n"
                + "numberOfPassengers: " + numberOfPassengers +"\n"
                + "CarpoolStatus: " + carpoolStatus + "\n"
                + "isCompleted :" + isDriver + "\n"
                + "isDeleted :" + isDriver + "\n"
                + "Driver :" + isDriver + "\n";
    }
}
