package com.kekod.weatherapp.util

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible

inline fun <reified T : Activity> Activity.navigate() {
    startActivity(Intent(this, T::class.java))

}

fun View.extStartAnimation(animId: Any) {
    when (animId) {
        is Int -> {
            this.startAnimation(AnimationUtils.loadAnimation(this.context, animId))
            this.isVisible = true
        }
        is Animation -> {
            this.startAnimation(animId)
            this.isVisible = true
        }
        else -> {
            Log.e("extStartAnimation", "Paramater type doesn't known")
        }
    }

}