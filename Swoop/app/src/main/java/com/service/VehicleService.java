package com.service;

import com.mapping.Vehicle;

import java.util.ArrayList;

/**
 * Created by karinapizano on 10/4/16.
 */

public class VehicleService {
    /**
     * Will create a new vehicle registered to its owner.
     *
     * @param vehicle The new Vehicle created will be stored in the DB.
     * @return The success or failure of registering a new car.
     */
    boolean createVehicle(Vehicle vehicle) {
        return false;
    }

    /**
     * User will be able to update their vehicle.
     *
     * @param vehicle The Vehicle object will be retrieved from DB.
     * @return The success or failure of updating a vehicle.
     */
    boolean updateVehicle(Vehicle vehicle) {
        return false;
    }

    /**
     * User will be able to delete a registered vehicle.
     *
     * @param vehicleId The vehicle will be retrieved from the DB.
     * @return The success or failure of deleting vehicle.
     */
    boolean deleteVehicle(String vehicleId) {
        return false;
    }

    /**
     * User is able to look for vehicle by userID.
     * @return A Vehicle that belongs to the userID entered.
     * @paramuserID UserID will be extracted from DB.
     */
    Vehicle getVehicleByUserId(String userId) {
        return null;
    }

    /**
     * Users will be able to filter Swoops by number of seats needed.
     *
     * @param numberOfSeats The number of seats will be extracted from DB.
     * @return ArrayList of vehicles that have the number amount of seats entered.
     */
    ArrayList<Vehicle> getVehiclesByNumberSeats(int numberOfSeats) {
        return null;
    }

    /**
     * Users will be able to filter Vehicles by model, to drive in luxury.
     *
     * @param model Vehicle Models will be extracted from the DB.
     * @return ArrayList of vehicles with model entered.
     */

    ArrayList<Vehicle> getVehiclesByModel(String model) {
        return null;
    }
}
