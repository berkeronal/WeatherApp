package com.kekod.weatherapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kekod.weatherapp.databinding.ActivityMainBinding
import com.kekod.weatherapp.util.navigate


private var _binding: ActivityMainBinding? = null
private val binding get() = _binding!!

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pillRed.setOnClickListener {
            navigate<DayActivity>()
        }

        binding.pillBlue.setOnClickListener {
            navigate<NightActivity>()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}