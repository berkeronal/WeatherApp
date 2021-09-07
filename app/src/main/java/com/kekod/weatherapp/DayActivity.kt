package com.kekod.weatherapp

import android.os.Bundle
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.kekod.weatherapp.abstracts.CustomAnimationListener
import com.kekod.weatherapp.databinding.ActivityDayBinding
import com.kekod.weatherapp.util.extCreateAndStartAnimation
import com.kekod.weatherapp.util.extStartAnimation
import com.kekod.weatherapp.util.handleStatusBar
import createAnimation

//https://developer.android.com/topic/libraries/view-binding#fragments
private var _binding: ActivityDayBinding? = null
private val binding get() = _binding!!

class DayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        handleStatusBar(this)
        super.onCreate(savedInstanceState)
        _binding = ActivityDayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //init anims
        val animationListener = object : CustomAnimationListener() {
            override fun onAnimationEnd(animation: Animation?) {
                //animate top
                with(binding) {
                    ivSun.extCreateAndStartAnimation(R.anim.zoom_in)
                    tvLocation.extCreateAndStartAnimation(R.anim.fade_in)
                }
                //left
                animateBottomLeft()
                //right
                animateBottomRight()
            }
        }
        val sunUp: Animation = createAnimation(R.anim.to_up, this, animationListener)
        binding.ivSun.extStartAnimation(sunUp)
    }

    private fun animateBottomLeft() {
        //init anims
        val leftToCenter: Animation = createAnimation(R.anim.left_to_center, this)
        with(binding) {
            tvHumidity.extStartAnimation(leftToCenter)
            ivHumiditySVG.extStartAnimation(leftToCenter)
            tvWeather.extStartAnimation(leftToCenter)
            ivWeatherSVG.extStartAnimation(leftToCenter)
            tvRain.extStartAnimation(leftToCenter)
            ivRainSVG.extStartAnimation(leftToCenter)
        }
    }

    private fun animateBottomRight() {
        //init anim
        val fadeIn: Animation = createAnimation(R.anim.fade_in, this)
        with(binding) {
            tvTempratureSVG.extStartAnimation(fadeIn)
            tvTemprature.extStartAnimation(fadeIn)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}