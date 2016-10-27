package com.service;

import com.mapping.Notification;

/**
 *
 * @author karinapizano
 * @version 1.0
*/

public class NotificationService {

    /**
     * Creates a new notification inserts into the DB.
     *
     * @param notification
     * @return The success or failure of creating a new Notification.
     */

    boolean createNotification(Notification notification) {
        return false;
    }

    /**
     * Updates the notification and updates inside DB.
     *
     * @param notification
     * @return The success or failure of updating the Notification.
     */

    boolean updateNotification(Notification notification) {
        return false;
    }

    /**
     * Deletes an existing notification from the DB.
     *
     * @param notificationID
     * @return Success or failure of deleting a notification.
     */

    boolean deleteNotification(Notification notificationID) {
        return false;
    }

    /**
     * Gets all the notification by the userID from DB.
     *
     * @param userID
     * @return Notification, if not, an error.
     */

    Notification getNotificationsByUserID(int userID) {
        return new Notification();
    }

    /**
     * Gets Notification by the CarpoolID from DB.
     * @param carpoolID
     * @return Notification, if not, an error.
     */
}
