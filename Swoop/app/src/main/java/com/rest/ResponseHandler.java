package com.rest;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by anaperez on 11/13/16.
 */

public class ResponseHandler extends AsyncHttpResponseHandler {

    @Override
    public void onStart() {
        // Initiated the request
    }

    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        // Successfully got a response
    }

    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable
            error)
    {
        // Response failed :(
    }

    public void onRetry(int retryNo) {
        // Request was retried
    }

    public void onProgress(long bytesWritten, long totalSize) {
        // Progress notification
    }

    @Override
    public void onFinish() {
        // Completed the request (either success or failure)
    }
}
