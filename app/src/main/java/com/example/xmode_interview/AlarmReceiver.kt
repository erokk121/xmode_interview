package com.example.xmode_interview

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val location = intent.extras?.get("location")
        if (location != null) {
            Toast.makeText(context, location.toString(), Toast.LENGTH_LONG).show()
            TODO("Prompt the user to choose at least 2 methods of persistently storing location info")
        }
    }
}
