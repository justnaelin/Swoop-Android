package com.rest;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.mapping.User;
import com.service.UserService;
import com.swoop.swoop.MainActivity;

import java.io.IOException;

import cz.msebera.android.httpclient.Header;

import static com.service.UserService.USER_ID;

/**
 * UserResource
 *
 * @author Yarely Chino
 * @version 1.0
 */

public final class UserResource {
    /**
     * Performs the retrieve Request call to access the read endpoint to read user.
     *
     * @param id user id
     */
    private static User userRetrieved = new User();
    private static boolean success = false;

    public static User retrieveRequest(final String id) {
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put(USER_ID, id);

        client.get(UserService.RETRIEVE_END_POINT, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                ObjectMapper objectMapper = new ObjectMapper();
                Log.d("UserResource", "SUCCESS" + bytes);
                Log.d("BYTES:", bytes.toString());
                try {
                    userRetrieved = objectMapper.readValue(bytes, User.class);
                    Log.d("RETRIEVED USER", userRetrieved.toString());
                    success = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (bytes == null) {
                    success = false;
                  /*  Intent intent = new Intent(context, CreateUser.class);
                    Bundle newBundle = new Bundle();
                    newBundle.putString("USER_ID",id);
                    intent.putExtras(newBundle);
                    context.startActivity(intent);
                } else {
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent); */
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Log.d("UserResource", "FAIL" + bytes);
            }
        });
        if (success == true) {
            return userRetrieved;
        }
        return null;
    }

    /**
     * Performs the request call to access the delete endpoint for delete user.
     *
     * @param id user id
     */
    private static void deleteRequest(String id) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put(USER_ID, id);
        client.get(UserService.DELETE_END_POINT, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.d("UserResource", "SUCCESS deleting user" + bytes);
                String statusCode = Integer.toString(i);
                Log.d("status code: ", statusCode);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Log.d("UserResource", "FAILURE deleting user" + bytes);
                String statusCode = Integer.toString(i);
                Log.d("status code: ", statusCode);
            }
        });
    }

    /**
     * Performs the request call to access the create endpoint for create user.
     *
     * @param params holds all parameters to create a user
     */
    public static void createRequest(RequestParams params, final Context context) {
        AsyncHttpClient client = new AsyncHttpClient();
        Log.d("PARAMS ", params.toString());
        client.get(UserService.CREATE_END_POINT, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.d("UserResource", "SUCCESS creating user" + bytes);
                String statusCode = Integer.toString(i);
                Log.d("status code: ", statusCode);
                //send to main activity if created user successfully.
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Log.d("UserResource", "FAIL" + bytes.toString());
                String statusCode = Integer.toString(i);
                Log.d("status code", statusCode);
            }
        });
    }

    /**
     * Performs the request call to access the update endpoint for update user.
     *
     * @param params holds all parameters to update
     */
    public static void updateRequest(RequestParams params) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(UserService.UPDATE_END_POINT, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                Log.d("UserResource", "SUCCESS updating user" + bytes);
                String statusCode = Integer.toString(i);
                Log.d("status code", statusCode);
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Log.d("UserResource", "FAILURE creating user" + bytes);
                String statusCode = Integer.toString(i);
                Log.d("status code", statusCode);

            }
        });
    }

}
