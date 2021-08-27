package com.kekod.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.kekod.weatherapp.databinding.ActivityDayBinding
import com.kekod.weatherapp.databinding.ActivityNightBinding

private lateinit var binding: ActivityNightBinding
class NightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init anims
        val moonUp: Animation = AnimationUtils.loadAnimation(this, R.anim.to_up)
        val moonZoom: Animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in_night)
        val bgZoom: Animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in_out_bg)
        val fadeIn: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val leftToCenter: Animation = AnimationUtils.loadAnimation(this, R.anim.left_to_center)



        moonUp.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.moon.startAnimation(moonZoom)
                binding.location.startAnimation(fadeIn)
                binding.location.isVisible = true

                //background (sky)
                binding.sky.startAnimation(bgZoom)


                //right
                binding.tempratureSVG.startAnimation(fadeIn)
                binding.tempratureText.startAnimation(fadeIn)
                binding.tempratureSVG.isVisible = true
                binding.tempratureText.isVisible = true

                //left
                binding.humidityText.startAnimation(leftToCenter)
                binding.humiditySVG.startAnimation(leftToCenter)
                binding.weatherText.startAnimation(leftToCenter)
                binding.weatherSVG.startAnimation(leftToCenter)
                binding.rainText.startAnimation(leftToCenter)
                binding.rainSVG.startAnimation(leftToCenter)
                binding.humidityText.isVisible = true
                binding.humiditySVG.isVisible = true
                binding.weatherText.isVisible = true
                binding.weatherSVG.isVisible = true
                binding.rainSVG.isVisible = true
                binding.rainText.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        binding.moon.startAnimation(moonUp)

    }
}