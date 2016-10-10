package com.swoop.swoop;

import android.app.Notification;

/**
 * @author karinapizano
 * @version 1.0
 */

public interface NotificationService {

    /**
     * Creates a new notification inserts into the DB.
     * @param notification
     * @return The success or failure of creating a new Notification.
     */

    boolean createNotification(Notification notification);

    /**
     * Updates the notification and updates inside DB.
     * @param notification
     * @return The success or failure of updating the Notification.
     */

    boolean updateNotification(Notification notification);

    /**
     * Deletes an existing notification from the DB.
     * @param notificationID
     * @return Success or failure of deleting a notification.
     */

    boolean deleteNotification(Notification notificationID);

    /**
     * Gets all the notification by the userID from DB.
     * @param userID
     * @return Notification, if not, an error.
     */

    Notification getNotificationsByUserID(int userID);

    /**
     * Gets Notification by the CarpoolID from DB.
     * @param carpoolID
     * @return Notification, if not, an error.
     */
}
