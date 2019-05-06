package com.example.xmode_interview

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import android.widget.Toast

class LocationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(context, "Location fixed!", Toast.LENGTH_SHORT).show()
        val location = intent.extras?.get(LocationManager.KEY_LOCATION_CHANGED) as Location?

        val newIntent = Intent(context.applicationContext, AlarmReceiver::class.java)
        PendingIntent.getBroadcast(
            context.applicationContext,
            0,
            newIntent.putExtra("location", location),
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }
}
