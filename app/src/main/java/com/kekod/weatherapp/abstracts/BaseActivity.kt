package com.kekod.weatherapp.abstracts

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.kekod.weatherapp.R

class BaseActivity : AppCompatActivity() {
    //init anims
   open val fadeIn: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
    val leftToCenter: Animation = AnimationUtils.loadAnimation(this, R.anim.left_to_center)


    fun animationHandler(element: Any?, animation: Animation) {
    }

}