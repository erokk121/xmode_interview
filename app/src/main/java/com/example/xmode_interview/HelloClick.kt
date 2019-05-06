package com.example.xmode_interview

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.support.v4.content.ContextCompat
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast

/*
    This class is for defining the logic of setting the alarm
    when the user presses "hello". Sets an alarm that sends a broadcast
    every hour which will trigger location update logic
 */

val interval: Long = if (BuildConfig.DEBUG) 1000 * 60 else 1000 * 60 * 60

class HelloClick : ClickableSpan() {


    override fun onClick(widget: View) {

        val context = widget.context.applicationContext
        Toast.makeText(context, "Task #1 Successful", Toast.LENGTH_SHORT).show()

        val am: AlarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.setRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + interval,
            interval,
            Intent(context, AlarmReceiver::class.java).let { intent ->
                PendingIntent.getBroadcast(
                    context,
                    0,
                    intent,
                    0
                )
            }
        )

        val hasLocationPermission =
            (context.let<Context, Int> { ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_COARSE_LOCATION) }
                    == PackageManager.PERMISSION_GRANTED) ||
                    (context.let<Context, Int> { ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_FINE_LOCATION) }
                            == PackageManager.PERMISSION_GRANTED)

        if (hasLocationPermission) {
            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f,
                Intent(context, LocationReceiver::class.java).let { intent ->
                    PendingIntent.getBroadcast(
                        context,
                        0,
                        intent,
                        0
                    )
                })
        }
    }

}