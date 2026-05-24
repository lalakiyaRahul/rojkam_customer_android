package com.cscodetech.townclap.fcm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.cscodetech.townclap.activity.FirstActivity;
import com.onesignal.OSNotificationOpenedResult;
import com.onesignal.OneSignal;
import org.json.JSONObject;
import com.cscodetech.townclap.MyApplication;

public class NotificationOpenedHandler implements OneSignal.OSNotificationOpenedHandler {
    @Override
    public void notificationOpened(OSNotificationOpenedResult result) {
        String title = result.getNotification().getTitle();
        JSONObject data = result.getNotification().getAdditionalData();

        Log.d("OneSignal", "Notification clicked: " + title);

        if (data != null) {
            String screen = data.optString("screen", "");
            String id = data.optString("id", "");

            Log.d("OneSignal", "Open screen: " + screen + ", ID: " + id);

            // Example: open specific Activity
            Context context = MyApplication.mContext.getApplicationContext();
            Intent intent = new Intent(context, FirstActivity.class);
            intent.putExtra("screen", screen);
            intent.putExtra("id", id);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
