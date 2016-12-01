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


    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

        Log.d("AsyncSwoopResponse", "Response code" + statusCode + " " + new String(responseBody) + "\n");

    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Log.d("AsyncSwoopResponse", "Response code" + statusCode + " " + new String(responseBody) + "\n");

    }
}
