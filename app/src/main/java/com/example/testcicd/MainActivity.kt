package com.example.testcicd

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(
            application, "8dc87273-55e3-47c9-af9c-1b83c1805801",
            Analytics::class.java, Crashes::class.java
        )

        findViewById<TextView>(R.id.btnTest).setOnClickListener {
            val properties = mutableMapOf(Pair("name", "amir"), Pair("surname", "ziarati"), Pair("age", "34"),)
            Analytics.trackEvent("button clicked", properties)
            Toast.makeText(this@MainActivity, "event sent", Toast.LENGTH_LONG).show()
//            Crashes.generateTestCrash()
        }
    }
}
