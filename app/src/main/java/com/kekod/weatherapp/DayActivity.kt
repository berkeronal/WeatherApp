package com.kekod.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.kekod.weatherapp.abstracts.CustomAnimationListener
import com.kekod.weatherapp.databinding.ActivityDayBinding
import com.kekod.weatherapp.databinding.ActivityMainBinding

//notlar
//-----------
//generic function refied for onclicklistener
//binding on destroy null : check
//bi abstract class açıp onaimationlistener da boş olanları onun içine tanı , böylece boş overrride göz önünde olmasın : check
//scope functions binding ler için. (with{binding}{}) : check
//onanimationlistener için sağ sol vs hepsini farklı fonksionlara böl : check
//complar arası bias : check


//https://developer.android.com/topic/libraries/view-binding#fragments
private var _binding: ActivityDayBinding? = null
private val binding get() = _binding!!

class DayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDayBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //init anims
        val sunUp: Animation = AnimationUtils.loadAnimation(this, R.anim.to_up)
        val sunZoom: Animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        //generice çek tekrardan kaçın
        val fadeIn: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)



        sunUp.setAnimationListener(object : CustomAnimationListener() {
            override fun onAnimationEnd(animation: Animation?) {


                //animate top
                with(binding) {
                    sun.startAnimation(sunZoom)
                    tvLocation.startAnimation(fadeIn)
                    tvLocation.isVisible = true
                }


                //left
                animateBottomLeft()

                //right
                animateBottomRight()

            }

        })

        binding.sun.startAnimation(sunUp)


    }

    fun animateTop() {

    }

    fun animateBottomLeft() {

        //init anims
        val leftToCenter: Animation = AnimationUtils.loadAnimation(this, R.anim.left_to_center)

        with(binding) {
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

        with(binding) {
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