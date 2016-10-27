package com.rest;

/**
 * InputUtility
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class InputUtility {

    /**
     * Checks if string is Null
     *
     * @param string
     * @return true if string is not null. false if string is null
     */
    public static boolean isNotNull(String string) {
        return string != null && string.trim().length() > 0 ? true : false;
    }


}
