package com.rest;

import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
/**
 * AsyncSwoopResponseHandler
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class AsyncSwoopResponseHandler extends AsyncHttpResponseHandler{



    public AsyncSwoopResponseHandler(){
        super();
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        Log.d("AsyncSwoopResponse", "Response code" + statusCode + " " + new String(responseBody) + "\n");

    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Log.d("AsyncSwoopResponse", "Response code" + statusCode + " " + new String(responseBody) + "\n");

    }
}
