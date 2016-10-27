package com.service;

import com.mapping.Review;

import java.util.ArrayList;

/**
 * @author karinapizano
 * @version 1.0
 */

public class ReviewService {

    /**
     * Creates a review and inserts it into DB.
     *
     * @param review
     * @return Success or failure of creating new review.
     */

    boolean createReview(Review review) {
        return false;
    }

    /**
     * Updates a review and the DB, if exists.
     *
     * @param review
     * @return Success or failure of creating a review.
     */

    boolean updateReview(Review review) {
        return false;
    }


    /**
     * Gets a Review by a specific ID.
     * @param
     * @return A Review or NULL.
    */
    boolean deleteReview(int reviewID) {
        return false;
    }

    /**
     * Gets a Review by a specific ID.
     *
     * @param reviewID
     * @return A Review or NULL.
     */

    Review getReviewByReviewID(int reviewID) {
        return new Review();
    }

    /**
     * Gets all reviews by a specific date.
     *
     * @param timestamp
     * @return List of all reviews at that specific date.
     */

    ArrayList<Review> getReviewsByDate(String timestamp) {

        return null;
    }
}
