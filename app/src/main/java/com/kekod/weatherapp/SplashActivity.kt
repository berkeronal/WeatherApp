package com.kekod.weatherapp

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.kekod.weatherapp.util.handleStatusBar
import com.kekod.weatherapp.util.navigate

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        handleStatusBar(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                navigate<MainActivity>()
                overridePendingTransition(0, R.anim.fade_out)
                finish()
            }
        }
        timer.start()
    }
}