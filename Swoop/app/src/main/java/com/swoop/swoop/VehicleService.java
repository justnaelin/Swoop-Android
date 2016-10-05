package com.swoop.swoop;

import java.util.ArrayList;

/**
 * @author karinapizano
 * @version 1.0
 */

public interface VehicleService {

    /**
     * Will create a new vehicle registered to its owner.
     * @param vehicle The new Vehicle created will be stored in the DB.
     * @return The success or failure of registering a new car.
     */
    boolean createVehicle(Vehicle vehicle);

    /**
     * User will be able to update their vehicle.
     * @param vehicle The Vehicle object will be created by user.
     * @return The success or failure of updating a vehicle.
     */
    boolean updateVehicle(Vehicle vehicle);

    /**
     * User will be able to delete a registered vehicle.
     * @param vehicle The vehicle will be retrieved from the DB.
     * @return The success or failure of deleting vehicle.
     */
    boolean deleteVehicle(Vehicle vehicle);

    /**
     * User is able to look for vehicle by userID.
     * @param userID UserID will be extracted from DB.
     * @return A Vehicle that belongs to the userID entered.
     *
     */
    Vehicle getVehicleByUserID(int userID);

    /** Users will be able to filter Swoops by number of seats needed.
     * @param num_seats The number of seats will be extracted from DB.
     * @return ArrayList of vehicles that have the number amount of seats entered.
     */
    ArrayList<Vehicle> getVehiclesByNumberSeats(int num_seats);

    /**
     * Users will be able to filter Vehicles by model, to drive in luxury.
     * @param model Model will be extracted from the DB.
     * @return ArrayList of vehicles with model entered.
     */


}

