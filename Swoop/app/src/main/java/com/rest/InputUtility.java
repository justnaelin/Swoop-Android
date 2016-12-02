package com.rest;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.util.List;

/**
 * InputUtility
 *
 * @author Yarely Chino
 * @version 1.0
 */

public final class InputUtility {

    /**
     * Checks if string is Null
     *
     * @param string
     * @return true if string is not null. false if string is null
     */
    public static boolean isNotNull(String string) {
        return string != null && string.trim().length() > 0 ? true : false;
    }

    /**
     * Checks if string is not negative
     *
     * @param string
     * @return true if string is positive, and false if string is negative
     */
    public static boolean isNotNegative(String string){

        return (Double.valueOf(string) >= 0 )? true : false;
    }

    /**
     * Typecast Boolean to String
     *
     * @param //Object
     * @return null if boolean is null, and string typecast if boolean is true or false
     */
    public static String valueOf(Object obj) {
        return (obj == null) ? "null" : obj.toString();
    }


    /**
     * reverseGeocordinates to an Address list
     *
     * @param //Object
     * @return null if boolean is null, and string typecast if boolean is true or false
     */
    public static List<Address> reverseGeo(String mLocation, Context context){

        String[] str = mLocation.split(",");
        String lati = str[0];
        String lngi = str[1];

        Geocoder geocoder = new Geocoder(context);

        try {
            List<Address> addresses = geocoder.getFromLocation(Double.parseDouble(lati), Double.parseDouble(lngi), 1);
            return addresses;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
