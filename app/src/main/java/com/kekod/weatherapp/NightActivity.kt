package com.kekod.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.kekod.weatherapp.abstracts.CustomAnimationListener
import com.kekod.weatherapp.databinding.ActivityDayBinding
import com.kekod.weatherapp.databinding.ActivityNightBinding

private var _binding: ActivityNightBinding? = null
private val binding get() = _binding!!

class NightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityNightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init anims
        val moonUp: Animation = AnimationUtils.loadAnimation(this, R.anim.to_up)
        val moonZoom: Animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in_night)
        val bgZoom: Animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in_out_bg)
        //generice çek tekrardan kaçın
        val fadeIn: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)



        moonUp.setAnimationListener(object: CustomAnimationListener() {
            override fun onAnimationEnd(animation: Animation?) {


                //animate top
                //background (sky)
                binding.sky.startAnimation(bgZoom)

                binding.ivMoon.startAnimation(moonZoom)
                binding.tvLocation.startAnimation(fadeIn)
                binding.tvLocation.isVisible = true


                //left
                animateBottomFeft()

                //right
                animateBottomRight()
            }
        })

        binding.ivMoon.startAnimation(moonUp)

    }
    fun animateBottomFeft() {
        //init anim
        val leftToCenter: Animation = AnimationUtils.loadAnimation(this, R.anim.left_to_center)

        with(binding){
            tvHumidity.startAnimation(leftToCenter)
            ivHumiditySVG.startAnimation(leftToCenter)
            tvWeather.startAnimation(leftToCenter)
            ivWeatherSVG.startAnimation(leftToCenter)
            tvRain.startAnimation(leftToCenter)
            ivRainSVG.startAnimation(leftToCenter)
            tvHumidity.isVisible = true
            ivHumiditySVG.isVisible = true
            tvWeather.isVisible = true
            ivWeatherSVG.isVisible = true
            ivRainSVG.isVisible = true
            tvRain.isVisible = true
        }
    }
    fun animateBottomRight() {
        //init anim
        val fadeIn: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        with(binding){
            tvTempratureSVG.startAnimation(fadeIn)
            tvTemprature.startAnimation(fadeIn)
            tvTempratureSVG.isVisible = true
            tvTemprature.isVisible = true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}