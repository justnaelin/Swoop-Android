package com.rest;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.service.UserService;

import static com.service.UserService.USER_ID;

/**
 * UserResource
 *
 * @author Yarely Chino
 * @version 1.0
 */


public final class UserResource {
    public static void retrieveRequest(final String id) throws InterruptedException {
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
    }


}
