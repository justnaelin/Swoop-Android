package com.mapping;

/**
 * Created by ychino on 10/4/16.
 * Carpool Mapper
 */

public class Carpool {

    //TODO: create startLocation and endLocation instance variables
    private String carpoolId;
    private String userId;
    private String timeStamp;
    private String startLocation;
    private String endLocation;
    private double rate;
    private int numberOfPassengers;
    private CarpoolStatus carpoolStatus;
    private Boolean isCompleted;
    private Boolean isDeleted;

    public String getId() { return carpoolId;}
    public void setId(String carpoolId) {this.carpoolId = carpoolId;}

    public String getUserId() {return userId;}
    public void setUserId(String userId) {this.userId = userId;}

    public String getTimeStamp() {return timeStamp;}
    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}

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

    @Override
    public String toString() {
        return "carpoolID: " + carpoolId + "\n"
                + "userID: " + userId + "\n"
                + "timeStamp: "  + timeStamp + "\n"
                + "startLocation: " + startLocation + "\n"
                + "endLocation: " + endLocation + String.format("\nRate: %s", rate) + "\n"
                + "numberOfPassengers: " + numberOfPassengers +"\n"
                + "CarpoolStatus: " + carpoolStatus + "\n";
    }
}
