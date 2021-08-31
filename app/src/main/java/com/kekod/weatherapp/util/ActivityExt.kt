package com.kekod.weatherapp.util

import android.app.Activity
import android.content.Intent

inline fun <reified T : Activity> Activity.navigate() {
    startActivity(Intent(this, T::class.java))

}