package com.rest;

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


}
