package com.swoop.swoop;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.mapping.User;
import com.service.UserService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anaperez on 12/1/16.
 */
public class UserSingleton {

    private static UserSingleton userSingleton;

    public static String userId;
    public static String firstName;
    public static String lastName;
    public static String emailAddress;
    public static List<String> reviewIds;
    public static String address;
    public static double averageRating;
    public static List<String> requestedCarpoolIds;
    public static String vehicleId;
    public static String birthday;
    public static String phoneNumber;
    public static String photoUrl;
    public static String profileUrl;

    private Context nextActivity;

    private UserSingleton(Context context, JSONObject userData) {
        this.nextActivity = context;

        try {
            verifyFacebookDataNotNull(userData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static UserSingleton getInstance(User user) {
        userId = user.getUserId();
        firstName = user.getName();
        lastName = user.getLastName();
        emailAddress = user.getEmailAddress();
        reviewIds = new ArrayList<>();
        reviewIds = user.getReviewIds();
        address = user.getAddress();
        averageRating = user.getAverageRating();
        requestedCarpoolIds = new ArrayList<>();
        requestedCarpoolIds = user.getRequestedCarpoolIds();
        vehicleId = user.getVehicleId();
        birthday = user.getBirthday();
        phoneNumber = user.getPhoneNumber();

        return userSingleton;

    }

    public static UserSingleton getInstance() {
        return userSingleton;
    }

    public static UserSingleton getInstance(Context context, JSONObject userData) {

        if (userSingleton == null) {
            userSingleton = new UserSingleton(context, userData);
            Log.d("UserSingleton", "userSingleton == null");
        }

        Log.d("RequestedSingleton", "getInstance\n");
        return userSingleton;
    }

    /**
     * Execute the RequestedCarpool by user endpoint
     */
    public void executeVerifyUser() {

         UserService.isUser(userId);
    }

    /**
     * Destroys the singleton since new view was created, note: this is to dereference the existing adapter
     */
    public static void destroySingleton() {
        userSingleton = null;
    }

    public void launchCreateUserActivity() {
        Intent createUserActivity = new Intent(nextActivity, CreateUserActivity.class);
        createUserActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        nextActivity.startActivity(createUserActivity);
    }

    private void verifyFacebookDataNotNull(JSONObject facebookUserData) throws JSONException {
        userId = facebookUserData.getString("id");

        if (facebookUserData.has("first_name")) {
            firstName = facebookUserData.getString("first_name");
        } else {
            firstName = "";
        }

        if (facebookUserData.has("last_name")) {
            lastName = facebookUserData.getString("last_name");
        } else {
            lastName = "";
        }

        if (facebookUserData.has("emailAddress")) {
            emailAddress = facebookUserData.getString("emailAddress");
        } else {
            emailAddress = "";
        }

        if(facebookUserData.has("picture")) {
            photoUrl = facebookUserData.getJSONObject("picture").getJSONObject("data").getString("url");
            Log.d("UserSingleton", photoUrl.toString());

        } else {
            photoUrl = "";
        }

        if (facebookUserData.has("birthday")) {
            birthday = facebookUserData.getString("birthday");
        } else {
            birthday = "";
        }

    }

    public void launchMainActivity() {
        Intent mainActivity = new Intent(nextActivity, MainActivity.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        nextActivity.startActivity(mainActivity);
    }
}
