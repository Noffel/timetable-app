package com.example.noffel.timetable;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


class Project_Notification_Reciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, ProjectNotificationService.class));
    }
}
