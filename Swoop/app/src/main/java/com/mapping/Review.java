package com.mapping;

/**
 * Created by ychino on 10/6/16.
 */
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

@DynamoDBTable(tableName = "Review")
public class Review {

    private String reviewId;
    private String comments;
    private String revieweeId;
    private String reviewerId;
    private String timeStamp;
    private double rating;

    @DynamoDBHashKey(attributeName="reviewId")
    public String getReviewId() {return reviewId;}
    public void setReviewId(String reviewId) {this.reviewId = reviewId;}

    @DynamoDBAttribute(attributeName="comments")
    public String getComments() {return comments;}
    public void setComments(String comments) {this.comments = comments;}

    @DynamoDBAttribute(attributeName="revieweeId")
    public String getRevieweeId() {return revieweeId;}
    public void setRevieweeId(String revieweeId) {this.revieweeId = revieweeId;}

    @DynamoDBAttribute(attributeName="reviewerId")
    public String getReviewerId() {return reviewerId;}
    public void setReviewerId(String reviewerId) {this.reviewerId = reviewerId;}

    @DynamoDBAttribute(attributeName="timeStamp")
    public String getTimeStamp() {return  timeStamp;}
    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}

    @DynamoDBAttribute(attributeName="rating")
    public double getRating() {return rating;}
    public void setRating(double rating) {this.rating = rating;}
}
