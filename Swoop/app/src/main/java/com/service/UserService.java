package com.service;

import android.content.Context;

import com.loopj.android.http.RequestParams;
import com.rest.InputUtility;
import com.rest.UserResource;

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
    public static  byte[] retrievedUser;
    public UserService() {

    }
    public static String verifyCreateUser(String userId, String name, String lastName,
                                        String email, String phoneNumber, String address, String birthday,
                                        double averageRating, String vehicleId, List<String> requestedCarpoolIds,
                                        List<String> reviewIds, Context context) {

        String validateResponse = validateCreate(userId, name, lastName, email, phoneNumber, address, birthday);
        if(validateResponse.equals(VALID)) {
            RequestParams params = new RequestParams();
            params.put(USER_ID, userId);
            params.put(NAME, name);
            params.put(LAST_NAME, lastName);
            params.put(HOME_ADDRESS, address);
            params.put(EMAIL_ADDRESS, email);
            params.put(AVERAGE_RATING, averageRating);
            params.put(PHONE_NUMBER, phoneNumber);
            params.put(BIRTHDAY, birthday);
            params.put(REQUESTED_CARPOOL_IDS, requestedCarpoolIds);
            params.put(VEHICLE_ID, vehicleId);
            params.put(REVIEW_IDS, reviewIds);
            UserResource.createRequest(params);
        }
        return validateResponse;

    }
    private static String validateCreate(String userId, String userName, String userLastName, String userEmail, String userCellPhone,
                                         String userHomeAddress, String userBirthday) {
        if(InputUtility.isNotNull(userId) &&
                InputUtility.isNotNull(userName) &&
                InputUtility.isNotNull(userLastName) &&
                InputUtility.isNotNull(userCellPhone) &&
                InputUtility.isNotNull(userEmail) &&
                InputUtility.isNotNull(userHomeAddress) &&
                InputUtility.isNotNull(userBirthday)) {
            return VALID;
        }
        return "please enter correct information for all fields";
    }

   /* public static boolean isUser(JSONObject userProfile) throws JSONException, InterruptedException {

        String id =  userProfile.getString("id");
        Log.d("USERIDDDdd:", id);
        if(!id.isEmpty()) {
            UserResource.retrieveRequest(id);
            if(retrievedUser!=null) {
                Log.d("userR not empty: ", retrievedUser.toString());
                return true;
            }
            Log.d("userRetrieved is empty", "empty");
            return false;

        }
        Log.d("userRetrieveddd", "empty");
        return false;
    } */
    public static void isUser(String id) {
        RequestParams params = new RequestParams();
        params.put(USER_ID, id);
        UserResource.retrieveUserById(params);
    }
}
