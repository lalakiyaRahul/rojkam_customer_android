package com.cscodetech.townclap;

import android.app.Application;
import android.content.Context;

import com.cscodetech.townclap.fcm.NotificationOpenedHandler;
import com.cscodetech.townclap.fcm.NotificationReceivedHandler;
import com.google.firebase.FirebaseApp;
import com.onesignal.OneSignal;

public class MyApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        FirebaseApp.initializeApp(this);

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId("bc1c73e3-04bb-4917-b21b-b31433e664cf");

        // Identify this app type (e.g., partner)
        OneSignal.sendTag("app_type", "customer");


        // Set notification opened handler
        OneSignal.setNotificationOpenedHandler(
                new NotificationOpenedHandler()
        );

        // Set notification received handler (optional)
        OneSignal.setNotificationWillShowInForegroundHandler(
                new NotificationReceivedHandler()
        );
    }



    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    private static boolean activityVisible;
}