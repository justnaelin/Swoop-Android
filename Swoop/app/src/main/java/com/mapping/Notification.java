package com.mapping;

/**
 * Created by ana perez on 10/7/16.
 * Summary: Notification mapper
 */

public class Notification {

    private String driverId;
    private String passengerId;
    private String notificationId;
    private String message;
    private String timeStamp;
    private String carpoolId;

    public void setNotificationId(String notificationId) {this.notificationId = notificationId;}
    public String getNotificationId() {return notificationId;}

    public void setDriverId(String driverId) {this.driverId = driverId; }
    public String getDriverId() {return driverId; }

    public void setPassengerId(String passengerId) {this.passengerId = passengerId;}
    public String getPassengerId() {return passengerId;}

    public void setMessage(String message) { this.message = message;}
    public String getMessage() {return message;}

    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}
    public String getTimeStamp() {return timeStamp;}

    public void setCarpoolId(String carpoolId) {this.carpoolId = carpoolId;}
    public String getCarpoolId() {return carpoolId;}

    @Override
    public String toString() {
        return "driverID: " + driverId + "\n"
                + "passengerID: " + passengerId + "\n"
                + "timeStamp: "  + timeStamp + "\n"
                + "notificationID: " + notificationId + "\n"
                + "message: " + message + "\n"
                + "carpoolID: " + carpoolId;
    }
}
