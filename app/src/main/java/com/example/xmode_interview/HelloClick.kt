package com.example.xmode_interview

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast

/*
    This class is for defining the logic of setting the alarm
    when the user presses "hello". Sets an alarm that sends a broadcast
    every hour which will trigger location update logic
 */

class HelloClick : ClickableSpan() {

    val interval : Long = if (BuildConfig.DEBUG) 1000 * 60 else 1000 * 60 * 60

    override fun onClick(widget: View) {
        Toast.makeText(widget.context, "Task #1 Successful", Toast.LENGTH_SHORT)

        val am: AlarmManager = widget.context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(widget.context, UpdateLocationReceiver::class.java)
        val alarmIntent = PendingIntent.getBroadcast(
            widget.context,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT
        )
        am.setRepeating (
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis(),
            interval,
            alarmIntent
        )
    }
}