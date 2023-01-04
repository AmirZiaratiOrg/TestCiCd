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
            application, "2e62058c-ceeb-4f64-a11d-43d9c2a250f5",
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