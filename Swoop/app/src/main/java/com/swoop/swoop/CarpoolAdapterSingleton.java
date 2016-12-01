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

    private CarpoolAdapter adapter;
    private static CarpoolAdapterSingleton requestedCarpoolAdapterSingleton;

    private CarpoolAdapterSingleton(CarpoolAdapter adapter) {
        this.adapter = adapter;
    }


    public static CarpoolAdapterSingleton getInstance(CarpoolAdapter adapter) {

        if (requestedCarpoolAdapterSingleton == null) {
            requestedCarpoolAdapterSingleton = new CarpoolAdapterSingleton(adapter);
        }
        Log.d("RequestedSingleton", "getInstance\n");

        return requestedCarpoolAdapterSingleton;
    }

    public void executeCreatedCarpoolByUser() {
        CarpoolService.executeCreatedCarpoolByUser("123456");
    }

    public void executeRequestedCarpoolByUser() {
        CarpoolService.executeRequestedCarpoolByUser("123456");
    }

    public void updateView(List<Carpool> requestedCarpools) {

        Log.d("RequestedCarpoolAdapter", adapter.toString());

        if (adapter != null) {
            adapter.upDateEntries(requestedCarpools);
        }
    }

    public static void destroySingleton(){
        requestedCarpoolAdapterSingleton = null;
    }

}