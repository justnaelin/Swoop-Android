package com.swoop.swoop;

import java.util.ArrayList;

/**
 * Carpool Service Interface
 *
 * @author Naelin Aquino
 * @version 1.0
 */

public interface CarpoolService {

    /**
     * Creates a new Carpool object in our database
     * @param carpool The Carpool object to be created in the database
     * @return The success or failure of creating the object
     *
     */
    boolean createCarpool(Carpool carpool);

    /**
     * Updates a Carpool object in our database
     * @param carpool The Carpool object to be updated in the database
     * @return The success or failure of updating the object
     *
     */
    boolean updateCarpool(Carpool carpool);

    /**
     * Deletes a Carpool object in our database
     * @param carpoolId The carpool ID used to delete a Carpool in the database
     * @return The success or failure of deleting the object
     *
     */
    boolean deleteCarpool(int carpoolId);

    /**
     * Gets all Carpools by a user's ID
     * @param userId The user's ID
     * @return A list of Carpools corresponding to the given user ID
     *
     */
    ArrayList<Carpool> getCarpoolsByUserId(int userId);

    /**
     * Gets all Carpools by the start location of the Carpool
     * @param startLocation The start location of the Carpool
     * @return A list of Carpools corresponding to the given start location
     *
     */
    ArrayList<Carpool> getCarpoolsByStartLocation(String startLocation);

    /**
     * Gets all Carpools by the end location of the Carpool
     * @param endLocation The end location of the Carpool
     * @return A list of Carpools corresponding to the given end location
     *
     */
    ArrayList<Carpool> getCarpoolsByEndLocation(String endLocation);

    /**
     * Gets all Carpools by completion status (e.g. completed/not completed)
     * @param isCompleted The status of the Carpool's completion
     * @return A list of Carpools corresponding to the given completion status
     *
     */
    ArrayList<Carpool> getCarpoolsByCompletionStatus(boolean isCompleted);

    /**
     * Gets all Carpools by deletion status (e.g. deleted/not deleted)
     * @param isDeleted The status of the Carpool's deletion
     * @return A list of Carpools corresponding to the given deletion status
     *
     */
    ArrayList<Carpool> getCarpoolsByDeletionStatus(boolean isDeleted);

    /**
     * Gets all Carpools by Carpool status
     * @param carpoolStatus The status of the Carpool
     * @return A list of Carpools corresponding to the given Carpool status
     *
     */
    ArrayList<Carpool> getCarpoolsByStatus(CarpoolStatus carpoolStatus);

    /**
     * Gets all Carpools by start location within specified mile radius
     * @param startLocation The start location of the Carpool
     * @param distance The miles used to determine the radius range
     * @return A list of Carpools corresponding to the given start location and mile radius
     *
     */
    ArrayList<Carpool> getCarpoolsByStartLocationAndRadius(String startLocation, double distance);

    /**
     * Gets all Carpools by end location within specified mile radius
     * @param endLocation The end location of the Carpool
     * @param distance The miles used to determine the radius range
     * @return A list of Carpools corresponding to the given end location and mile radius
     *
     */
    ArrayList<Carpool> getCarpoolsByEndLocationAndRadius(String endLocation, double distance);

}

