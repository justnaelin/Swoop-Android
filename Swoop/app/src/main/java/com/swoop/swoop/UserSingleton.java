package com.swoop.swoop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.service.UserService;

/**
 * Created by anaperez on 12/1/16.
 */
public class UserSingleton {

    private  static UserSingleton userSingleton;
    private Bundle userBundle;
    private   Context nextActivity;

    private UserSingleton(Context context, Bundle userBundle) {
        this.nextActivity = context;
        this.userBundle = userBundle;

    }
    public static UserSingleton getInstance(Context context, Bundle userBundle) {

        if (userSingleton == null) {
            userSingleton = new UserSingleton(context, userBundle);
        }
        Log.d("RequestedSingleton", "getInstance\n");
        return userSingleton;
    }
    /**
     * Execute the RequestedCarpool by user endpoint
     */
    public void executeVerifyUser() {
        /*
        TODO: need to retrieve unique user id using the Facebook login
        */
        UserService.isUser(UserService.USER_ID);
    }
    /**
     * Destroys the singleton since new view was created, note: this is to dereference the existing adapter
     */
    public static void destroySingleton(){
        userSingleton = null;
    }

    public void launchCreateUserActivity(){
        Intent createUserActivity = new Intent(nextActivity, CreateUserActivity.class);
        createUserActivity.putExtras(userBundle);
        nextActivity.startActivity(createUserActivity);
    }
}
