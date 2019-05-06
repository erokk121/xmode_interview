package com.example.xmode_interview

import android.Manifest
import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()

        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
            0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloWorldView = findViewById<TextView>(R.id.textView)
        val spannableString = SpannableString(helloWorldView.text)

        spannableString.setSpan(HelloClick(), 0, "hello".length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        helloWorldView.text = spannableString
        helloWorldView.movementMethod = LinkMovementMethod.getInstance()
    }
}
