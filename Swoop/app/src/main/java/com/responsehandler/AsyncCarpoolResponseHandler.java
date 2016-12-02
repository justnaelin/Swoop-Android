package com.responsehandler;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

/**
 * AsyncCarpoolResponseHandler
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class AsyncCarpoolResponseHandler extends AsyncHttpResponseHandler{

    private byte[] responseBodyResult;
    public AsyncCarpoolResponseHandler(){
        super();
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        Log.d("RESPONSE CODE:", String.valueOf(statusCode));
//        Log.d("AsyncSwoopResponse", "Response code" + statusCode + " " + new String(responseBody) + "\n");
        if(responseBody != null) {
            Log.d("RESPONSE CODE:", String.valueOf(statusCode));
            for (byte b : responseBodyResult = responseBody) {}
        }
        else{
            Log.d("RESPONSE CODE:", String.valueOf(statusCode));
            responseBodyResult = null;
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Log.d("AsyncSwoopResponse", "Response code" + statusCode + " " + new String(responseBody) + "\n");

    }
    public byte[] returnResponse() {
        return responseBodyResult;
    }
}
