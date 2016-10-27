package com.service;

import android.content.Context;
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
    public static final String NUMBER_OF_PASSANGERS = "numberOfPassangers";
    public static final String CARPOOL_STATUS = "carpoolStatus";
    public static final String IS_COMPLETED = "isCompleted";
    public static final String IS_DELETED = "isDeleted";
    public static final String IS_DRIVER = "isDriver";
    public static final String RETRIEVE_END_POINT = "http://10.0.2.2:8080/rest/carpool/retrieve";
    public static final String CREATE_END_POINT = "http://10.0.2.2:8080/rest/carpool/create";
    public static final String UPDATE_END_POINT = "http://10.0.2.2:8080/rest/carpool/update";
    public static final String DELETE_END_POINT = "http://10.0.2.2:8080/rest/carpool/delete";


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

    public static void verifyCreate(String carpoolId, String userId, String startLocation,
                                    String endLocation, String requestDate, String rate,
                                    String numberOfPassengers, CarpoolStatus carpoolStatus,
                                    boolean isDriver,
                                    Context context) {
        if (validateCreate(rate, numberOfPassengers, carpoolStatus, context)) {

            RequestParams params = new RequestParams();

            params.put(CARPOOL_ID, carpoolId);
            params.put(USER_ID, userId);
            params.put(START_LOCATION, startLocation);
            params.put(END_LOCATION, endLocation);
            params.put(REQUEST_DATE, requestDate);
            params.put(RATE, rate);
            params.put(NUMBER_OF_PASSANGERS, numberOfPassengers);
            params.put(CARPOOL_STATUS, carpoolStatus);
            params.put(IS_DRIVER, isDriver);
            params.put(IS_COMPLETED, false);
            params.put(IS_DELETED, false);

            CarpoolResource.createRequest(params);

        }
    }


    /**
     * Checks for input carpool validation for all fields
     *
     * @return true if all information is valid, false if there is invalid information.
     */
    private static boolean validateCreate(String carpoolId, String userId, String startLocation,
                                          String endLocation, String requestDate, String rate,
                                          String numberOfPassengers, CarpoolStatus carpoolStatus,
                                          boolean isDriver,
                                          Context context) {

        if (InputUtility.isNotNull(carpoolId) &&
                InputUtility.isNotNull(userId) &&
                InputUtility.isNotNull(startLocation) &&
                InputUtility.isNotNull(endLocation) &&
                InputUtility.isNotNull(requestDate) && carpoolStatus.toString() == CarpoolStatus.PENDING.toString()) {

            try {
                Integer.valueOf(numberOfPassengers);
            } catch (NumberFormatException e) {
                createToast(context, "Please, enter a valid passanger number");
                return false;
            }

            try {
                Double.valueOf(rate);

            } catch (NumberFormatException e) {
                createToast(context, "Please, enter a valid rate value");
                return false;
            }

        }

        createToast(context, "Please enter all fields");
        return false;
    }


    /**
     * Checks for input carpool validation for only rate, numberOfPassangers
     *
     * @return true if all information is valid, false if there is invalid information.
     */
    private static boolean validateCreate(String rate,
                                          String numberOfPassengers,
                                          CarpoolStatus carpoolStatus,
                                          Context context) {

        if (carpoolStatus.toString() == CarpoolStatus.PENDING.toString()) {

            try {
                Integer.valueOf(numberOfPassengers);
            } catch (NumberFormatException e) {
                createToast(context, "Please, enter a valid passanger number");
                return false;
            }

            try {
                Double.valueOf(rate);
                return true;

            } catch (NumberFormatException e) {
                createToast(context, "Please, enter a valid rate value");
                return false;
            }

        }
        return false;
    }


    public static void createToast(Context context, String s) {
        Toast toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
        toast.show();
    }


}
