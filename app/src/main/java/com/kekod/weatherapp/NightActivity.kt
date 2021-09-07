package com.kekod.weatherapp

import android.os.Bundle
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.kekod.weatherapp.abstracts.CustomAnimationListener
import com.kekod.weatherapp.databinding.ActivityNightBinding
import com.kekod.weatherapp.util.extCreateAndStartAnimation
import com.kekod.weatherapp.util.extStartAnimation
import com.kekod.weatherapp.util.handleStatusBar
import createAnimation

private var _binding: ActivityNightBinding? = null
private val binding get() = _binding!!

class NightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        handleStatusBar(this)
        super.onCreate(savedInstanceState)
        _binding = ActivityNightBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //init anims
        val moonZoom: Animation = createAnimation(R.anim.zoom_in_night, this)
        val bgZoom: Animation = createAnimation(R.anim.zoom_in_out_bg, this)
        val animationListener = object : CustomAnimationListener() {
            override fun onAnimationEnd(animation: Animation?) {
                binding.sky.extStartAnimation(bgZoom)
                binding.ivMoon.extStartAnimation(moonZoom)
                binding.tvLocation.extCreateAndStartAnimation(R.anim.fade_in)
                //left
                animateBottomFeft()
                //right
                animateBottomRight()
            }
        }
        val moonUp: Animation = createAnimation(R.anim.to_up, this, animationListener)
        binding.ivMoon.extStartAnimation(moonUp)

    }

    private fun animateBottomFeft() {
        //init anim
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