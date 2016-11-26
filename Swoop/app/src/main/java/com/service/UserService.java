package com.service;

import android.content.Context;

import java.util.List;

/**
 * Created by anaperez on 11/26/16.
 */

public class UserService {
    //Table and attributes name
    public static final String TABLE_NAME = "User";
    public static final String USER_ID = "userId";
    public static final String NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL_ADDRESS = "emailAddress";
    public static final String AVERAGE_RATING = "averageRating";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String BIRTHDAY = "birthday";
    public static final String HOME_ADDRESS = "address";
    public static final String VEHICLE_ID = "vehicleId";
    public static final String REQUESTED_CARPOOL_IDS = "requestedCarpoolIds";
    public static final String REVIEW_IDS = "reviewIds";
    public static final String VALID = "VALID";
    public static final String RETRIEVE_END_POINT = "http://10.0.2.2:8080/rest/user/retrieve";
    public static final String UPDATE_END_POINT = "http://10.0.2.2:8080/rest/user/update";
    public static final String DELETE_END_POINT = "http://10.0.2.2:8080/rest/user/delete";
    public static final String CREATE_END_POINT = "http://10.0.2.2:8080/rest/user/create";

    public UserService() {

    }
    public static String verifyCreateUser(String userId, String name, String lastName,
                                        String email, String phoneNumber, String address, String birthday,
                                        double averageRating, String vehicleId, List<String> requestedCarpoolIds,
                                        List<String> reviewIds, Context context) {

        return null;

    }
}
