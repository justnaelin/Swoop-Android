package com.swoop.swoop;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author karinapizano
 * @version 1.0
 */

public interface ReviewService {

    /**
     * Creates a review and inserts it into DB.
     * @param review
     * @return Success or failure of creating new review.
     */

 //   boolean createReview(Review review);

    /**
     * Updates a review and the DB, if exists.
     * @param  review
     * @return Success or failure of creating a review.
     */

  //  boolean updateReview(Review review);

    /**
     * Deletes a review from the DB.
     * @param  reviewID
     * @return Success or failure of deleting review from DB.
     */

    boolean deleteReview(int reviewID);

    /**
     * Gets a Review by a specific ID.
     * @param reviewID
     * @return A Review or NULL.
     */

  //  Review getReviewByReviewID(int reviewID);

    /**
     * Gets all reviews by UserID fromt he DB.
     * @param userID
     * @return List of all reviews from the userID.
     */

//    ArrayList<Review> getReviewsByUserID(int userID);

    /**
     * Gets all reviews by a specific date.
     * @param timestamp
     * @return List of all reviews at that specific date.
     */

  //  ArrayList<Review> getReviewsByDate(Date timestamp);
}

