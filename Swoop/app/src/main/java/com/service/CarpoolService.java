package com.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.rest.CarpoolResource;
import com.rest.InputUtility;
import com.loopj.android.http.RequestParams;
import com.mapping.Carpool;
import com.mapping.CarpoolStatus;

import java.util.ArrayList;

/**
 * Carpool Service (Controller)
 *
 * @author Naelin Aquino
 * @version 1.0
 */

public class CarpoolService {


    //Table and attribute's name
    public static final String TABLE_NAME = "Carpool";
    public static final String CARPOOL_ID = "carpoolId";
    public static final String USER_ID = "userId";
    public static final String START_LOCATION = "startLocation";
    public static final String END_LOCATION = "endLocation";
    public static final String REQUEST_DATE = "requestDate";
    public static final String RATE = "rate";
    public static final String NUMBER_OF_PASSENGERS = "numberOfPassengers";
    public static final String CARPOOL_STATUS = "carpoolStatus";
    public static final String IS_COMPLETED = "isCompleted";
    public static final String IS_DELETED = "isDeleted";
    public static final String IS_DRIVER = "isDriver";
    public static final String RETRIEVE_END_POINT = "http://10.0.2.2:8080/rest/carpool/retrieve";
    public static final String CREATE_END_POINT = "http://10.0.2.2:8080/rest/carpool/create";
    public static final String UPDATE_END_POINT = "http://10.0.2.2:8080/rest/carpool/update";
    public static final String DELETE_END_POINT = "http://10.0.2.2:8080/rest/carpool/delete";
    public static final String RETRIEVE_CREATED_CARPOOLS_BY_USER_ID = "http://10.0.2.2:8080/rest/carpool/retrieve/userId";
    public static final String RETRIEVE_REQUESTED_CARPOOLS_BY_USER_ID = "http://10.0.2.2:8080/rest/carpool/retrieve/userId2";
    public static final String RETRIEVE_ALL_CARPOOLS = "http://10.0.2.2:8080/rest/carpool/retrieve/all";
    public static final String VALID = "VALID";
    public static final String USER_TEMP_ID = "Ux000000001";


    public static boolean createCarpool(Carpool carpool) {

        return false;
    }

    public boolean updateCarpool(Carpool carpool) {
        return false;
    }

    public boolean deleteCarpool(int carpoolId) {
        return false;
    }

    public ArrayList<Carpool> getCarpoolsByUserId(int userId) {
        return null;
    }

    public ArrayList<Carpool> getCarpoolsByStartLocation(String startLocation) {
        return null;
    }

    public ArrayList<Carpool> getCarpoolsByEndLocation(String endLocation) {
        return null;
    }

    public ArrayList<Carpool> getCarpoolsByCompletionStatus(boolean isCompleted) {
        return null;
    }

    public ArrayList<Carpool> getCarpoolsByDeletionStatus(boolean isDeleted) {
        return null;
    }

    public ArrayList<Carpool> getCarpoolsByStatus(CarpoolStatus carpoolStatus) {
        return null;
    }

    public ArrayList<Carpool> getCarpoolsByStartLocationAndRadius(String startLocation, double distance) {
        return null;
    }

    public ArrayList<Carpool> getCarpoolsByEndLocationAndRadius(String endLocation, double distance) {
        return null;
    }

    public static String verifyCreate(String startLocation,
                                      String endLocation, String requestDate, String rate,
                                      String numberOfPassengers, CarpoolStatus carpoolStatus,
                                      boolean isDriver) {
        String validateResponse = validateCreate(rate, numberOfPassengers, carpoolStatus);
        if (validateResponse.equals(VALID)) {

            RequestParams params = new RequestParams();
            params.put(USER_ID, USER_TEMP_ID);
            params.put(START_LOCATION, startLocation);
            params.put(END_LOCATION, endLocation);
            params.put(REQUEST_DATE, requestDate);
            params.put(RATE, rate);
            params.put(NUMBER_OF_PASSENGERS, numberOfPassengers);
            params.put(CARPOOL_STATUS, carpoolStatus.toString());
            params.put(IS_DRIVER, InputUtility.valueOf(isDriver));
            params.put(IS_COMPLETED, "false");
            params.put(IS_DELETED, "false");

            Log.d("CarpoolService","Before crating the request in parameters " + carpoolStatus.toString() + params.toString());
            CarpoolResource.createRequest(params);

        }
        return validateResponse;
    }


    /**
     * Checks for input carpool validation for only rate, numberOfPassangers
     *
     * @return a string validation message, if all information is valid or invalid.
     */
    private static String validateCreate(String rate,
                                         String numberOfPassengers,
                                         CarpoolStatus carpoolStatus) {

        if (carpoolStatus.toString() == CarpoolStatus.PENDING.toString()) {

            try {
                Integer.valueOf(numberOfPassengers);
            } catch (NumberFormatException e) {
                return "Please, enter a valid passenger number";
            }

            try {
                Double.valueOf(rate);
                return VALID;

            } catch (NumberFormatException e) {
                return "Please, enter a valid rate value";
            }

        }
        return "Invalid carpool status";
    }


    public static void executeRequestedCarpoolByUser(String id){

        RequestParams params = new RequestParams();
        params.put(USER_ID, id);

        CarpoolResource.retrieveRequestedByUser(params);
    }

    public static void executeCreatedCarpoolByUser(String id){

        RequestParams params = new RequestParams();
        params.put(USER_ID, id);

        CarpoolResource.retrieveCreatedByUser(params);
    }
    public static void executeAllCreatedCarpools(){
        CarpoolResource.retrieveAllCarpools();
    }
}
