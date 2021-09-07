package com.kekod.weatherapp.util

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible

inline fun <reified T : Activity> Activity.navigate() {
    startActivity(Intent(this, T::class.java))

}

fun View.extCreateAndStartAnimation(animId: Int) {
    this.startAnimation(AnimationUtils.loadAnimation(this.context, animId))
    this.isVisible = true
}

fun View.extStartAnimation(animation: Animation) {
    this.startAnimation(animation)
    this.isVisible = true
}
