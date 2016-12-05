package com.rest;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.mapping.User;
import com.service.UserService;
import com.swoop.swoop.UserSingleton;

import org.apache.http.Header;
import org.json.JSONException;

/**
 * UserResource
 *
 * @author Yarely Chino
 * @version 1.0
 */


public final class UserResource {
   /* public static void retrieveRequest(final String id) throws InterruptedException {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put(USER_ID, id);
        byte[] responseFromCall;
        AsyncSwoopResponseHandler response = new AsyncSwoopResponseHandler();
        final RequestHandle requestHandle = client.get(UserService.RETRIEVE_END_POINT, params, response);
        if(requestHandle.isFinished()) {
            responseFromCall = response.returnResponse();
            if(responseFromCall != null) {
                Log.d("RESPONSE: ", responseFromCall.toString());
                UserService.retrievedUser = responseFromCall;
            }
            UserService.retrievedUser = null;
            Log.d("RESPONSE null: ", responseFromCall.toString());
        }
    } */
    private static ResponseHandlerInterface createUserHandler() {
        return new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200 && responseBody != null) {
                    Log.d("UserResource success", "Response code" + statusCode + new String(responseBody) + "\n");

                }else{
                    Log.d("User success null", "Response code" + statusCode + "\n");
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if(responseBody != null){
                    Log.d("UserResource Failure", "Response code create" + statusCode +  new String(responseBody) + error.toString() + "\n");

                }else{
                    Log.d("UserResource Failure", "Response code create" + statusCode + error.toString() + "\n");

                }
            }
        };

    }
    private static ResponseHandlerInterface retrieveUserResponseHandler() {
        return new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200 && responseBody != null) {
                    Log.d("UserResource success", "Response code" + statusCode + new String(responseBody) + "\n");

                    User newUser = new User();
                    try {
                        newUser = new User(new String(responseBody));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    UserSingleton userSingleton = UserSingleton.getInstance(newUser);
                    userSingleton.launchMainActivity();

                }else{
                    Log.d("User success null", "Response code" + statusCode + "\n");

                    User newUser = new User();
                    try {
                        newUser = new User(new String(responseBody));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    UserSingleton userSingleton = UserSingleton.getInstance(newUser);
                    userSingleton.launchCreateUserActivity();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if(responseBody != null){
                    Log.d("UserResource Failure", "Response code create" + statusCode +  new String(responseBody) + error.toString() + "\n");

                }else{
                    Log.d("UserResource Failure", "Response code create" + statusCode + error.toString() + "\n");

                }
            }
        };

    }
    public static void createRequest(RequestParams params) {

        // Instantiate Http Request Param Object
        AsyncHttpClient client = new AsyncHttpClient();

        //CREATE REQUEST
        client.get(UserService.CREATE_END_POINT, params, UserResource.createUserHandler());
        // client.get(CarpoolService.CREATE_END_POINT, params, new AsyncCarpoolResponseHandler());

    }
    public static void retrieveUserById(RequestParams params) {

        // Instantiate Http Request Param Object
        AsyncHttpClient client = new AsyncHttpClient();

        //RETRIEVE BY USERID
        client.get(UserService.RETRIEVE_END_POINT, params, UserResource.retrieveUserResponseHandler());
    }


}
