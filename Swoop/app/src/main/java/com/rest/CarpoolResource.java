package com.rest;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.service.CarpoolService;

import cz.msebera.android.httpclient.Header;

/**
 * Carpool Resource (Model)
 *
 * @author Yarely Chino
 * @version 1.0
 */


public final class CarpoolResource {


    private static ResponseHandlerInterface executeResponseHandler() {
        return new AsyncHttpResponseHandler() {

//           @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("CreateCarpoolActivity", "Response code" + statusCode + " " + new String(responseBody));
            }
//            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("CreateCarpoolActivity", "Response error code" + statusCode + " " + new String(responseBody) + " after the body");
            }
        };
    }

    /**
     * Performs the retrieve Request call to access the read endpoint.
     */
    private static void retreiveRequest(String id) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put(CarpoolService.CARPOOL_ID, id);

        //RETREIVE REQUEST
        client.get(CarpoolService.RETRIEVE_END_POINT, params, CarpoolResource.executeResponseHandler());
    }


    /**
     * Performs the retrieve Request call to delete endpoint.
     */
    private static void deleteRequest(String id) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put(CarpoolService.CARPOOL_ID, id);

        //DELETE REQUEST
        client.get(CarpoolService.DELETE_END_POINT, params, CarpoolResource.executeResponseHandler());
    }


    /**
     * Performs the request call to access the create endpoint.
     */
    public static void createRequest(RequestParams params) {

        /*TODO: fix create endpoint 
        Status: current endpoint gets error code 400:
         */

        // Instantiate Http Request Param Object
        AsyncHttpClient client = new AsyncHttpClient();

        //retreiveRequest("123456"); check if endpoint retreive works

        //CREATE REQUEST
        client.get(CarpoolService.CREATE_END_POINT, params, CarpoolResource.executeResponseHandler());
    }

    /**
     * Performs the request call to access the update endpoint.
     */
    public static void updateRequest(RequestParams params) {

        // Instantiate Http Request Param Object
        AsyncHttpClient client = new AsyncHttpClient();

        //UPDATE REQUEST
        client.get(CarpoolService.UPDATE_END_POINT, params, CarpoolResource.executeResponseHandler());
    }

    /**
     * Performs the request call to access the retrieve by user UPDATE endpoint.
     */
    public static void retrieveByUser(RequestParams params) {

        // Instantiate Http Request Param Object
        AsyncHttpClient client = new AsyncHttpClient();

        //UPDATE REQUEST
        client.get(CarpoolService.RETRIEVE_BY_USER_END_POINT, params, CarpoolResource.executeResponseHandler());
    }

}
