package com.example.xmode_interview

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.support.v4.content.ContextCompat
import android.widget.Toast

/*
    Here is a receiver that will receive periodic broadcast
    set off by Android AlarmManager. Here we are using the LocationManager
    to get the last known location from the passive provider, which instead
    of fixing the location now gets the location from the providers in the
    system. This should be sufficient in the case of an update that runs
    every hour.
 */

class UpdateLocationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val permissionGranted
                = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

        if (permissionGranted) {
            val lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
            Toast.makeText(context, lastKnownLocation.toString(), Toast.LENGTH_LONG)
            TODO("Prompt the user to choose at least 2 methods of persistently storing location info")
        }
    }
}
