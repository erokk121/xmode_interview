package com.example.xmode_interview

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloWorldView = findViewById<TextView>(R.id.textView)
        val spannableString = SpannableString(helloWorldView.text)

        spannableString.setSpan(HelloClick(), 0, "hello".length - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}
