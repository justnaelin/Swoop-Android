package com.mapping;

/**
 * Created by ana perez on 10/7/16.
 * Summary: Address Mapper to DynamoDB
 */

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "Address")
public class Address {

    private String street;
    private String city;
    private String userId;
    private String zipCode;

    @DynamoDBHashKey(attributeName="userId")
    public void setUserId(String userId) {this.userId = userId;}
    public String getUserId() {return userId;}

    @DynamoDBAttribute(attributeName = "street")
    public void setStreet(String street) {this.street = street;}
    public String getStreet() {return street;}

    @DynamoDBAttribute(attributeName = "city")
    public void setCity(String city) {this.city = city;}
    public String getCity() {return  city;}

    @DynamoDBAttribute(attributeName = "zipCode")
    public void setZipCode(String zipCode) {this.zipCode = zipCode;}
    public String getZipCode() {return zipCode;}

}
