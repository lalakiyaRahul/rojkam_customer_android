package com.cscodetech.townclap.fcm;

import com.onesignal.OSNotification;
import com.onesignal.OSNotificationReceivedEvent;
import com.onesignal.OneSignal;


public class NotificationReceivedHandler implements OneSignal.OSNotificationWillShowInForegroundHandler {
    @Override
    public void notificationWillShowInForeground(OSNotificationReceivedEvent event) {
        OSNotification notification = event.getNotification();
        String title = notification.getTitle();
        String body = notification.getBody();

        // Log or modify the notification
       // Log.d("OneSignal", "Notification received: " + title + " - " + body);

        // Optionally show the notification
        event.complete(notification);
    }
}
