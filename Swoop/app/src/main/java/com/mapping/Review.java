package com.mapping;


/**
 * Review
 *
 * @author Yarely Chino
 * @version 1.0
 */

public class Review {

    private String reviewId;
    private String comments;
    private String revieweeId;
    private String reviewerId;
    private String timeStamp;
    private double rating;

    public String getReviewId() {return reviewId;}
    public void setReviewId(String reviewId) {this.reviewId = reviewId;}

    public String getComments() {return comments;}
    public void setComments(String comments) {this.comments = comments;}

    public String getRevieweeId() {return revieweeId;}
    public void setRevieweeId(String revieweeId) {this.revieweeId = revieweeId;}

    public String getReviewerId() {return reviewerId;}
    public void setReviewerId(String reviewerId) {this.reviewerId = reviewerId;}

    public String getTimeStamp() {return  timeStamp;}
    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}

    public double getRating() {return rating;}
    public void setRating(double rating) {this.rating = rating;}

    @Override
    public String toString() {
        return "ReviewID: " + reviewId + "\n"
                + "Comment: " + comments + "\n"
                + "RevieweeID: "  + revieweeId + "\n"
                + "ReviewerID: " + reviewerId + "\n"
                + "timeStamp: " + timeStamp + String.format("\nRating: %s", rating);
    }
}
