package com.mapping;



/**
 * Created by anaperez on 10/15/16.
 * Status of a Carpool
 */
public enum CarpoolStatus {
    PENDING("Pending"),
    APPROVED("Approved"),
    DENIED("Denied"),
    REQUESTED("Requested");

    private final String fieldDescription;

    private CarpoolStatus(String value) {
        fieldDescription = value;
    }

    public String getFieldDescription() {
        return "";
    }
}
