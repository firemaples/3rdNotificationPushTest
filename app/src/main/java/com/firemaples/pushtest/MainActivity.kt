package com.firemaples.pushtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workdo.networktester.NetworkTester

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkTester.test("firemaples")
    }
}
