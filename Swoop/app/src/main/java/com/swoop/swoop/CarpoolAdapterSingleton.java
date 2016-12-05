package com.swoop.swoop;

import android.util.Log;

import com.mapping.Carpool;
import com.service.CarpoolService;

import java.util.List;


/**
 * CarpoolAdapterSingleton
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class CarpoolAdapterSingleton {

    //Keeps track of the working adapter(Controller)
    private CarpoolAdapter adapter;
    private static CarpoolAdapterSingleton requestedCarpoolAdapterSingleton;

    private CarpoolAdapterSingleton(CarpoolAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * Reference a single CarpoolAdapterSingleton instance and returns that reference
     *
     * @return new CarpoolInstance if no current reference, else it returns is reference.
     */
    public static CarpoolAdapterSingleton getInstance(CarpoolAdapter adapter) {

        if (requestedCarpoolAdapterSingleton == null) {
            requestedCarpoolAdapterSingleton = new CarpoolAdapterSingleton(adapter);
        }
        Log.d("RequestedSingleton", "getInstance\n");
        return requestedCarpoolAdapterSingleton;
    }

    /**
     * Execute the CreatedCarpool by user endpoint
     */
    public void executeCreatedCarpoolByUser() {

        /*
        TODO: need to retrieve unique user id using the Facebook login
        */
        CarpoolService.executeCreatedCarpoolByUser(UserSingleton.userId);
    }

    /**
     * Execute the RequestedCarpool by user endpoint
     */
    public void executeRequestedCarpoolByUser() {
        /*
        TODO: need to retrieve unique user id using the Facebook login
        */
        CarpoolService.executeRequestedCarpoolByUser(UserSingleton.userId);
    }


    /**
     * Signals the Adapter to update the view with new content
     */
    public void updateView(List<Carpool> requestedCarpools) {

        Log.d("RequestedCarpoolAdapter", adapter.toString());

        if (adapter != null) {
            adapter.upDateEntries(requestedCarpools);
        }
    }


    /**
     * Destroys the singleton since new view was created, note: this is to dereference the existing adapter
     */
    public static void destroySingleton(){
        requestedCarpoolAdapterSingleton = null;
    }

    public void executeAllCarpools(){
        CarpoolService.executeAllCreatedCarpools();
    }
}