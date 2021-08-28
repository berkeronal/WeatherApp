package com.kekod.weatherapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kekod.weatherapp.databinding.ActivityMainBinding
import android.widget.Toast
import com.kekod.weatherapp.databinding.ActivityNightBinding


private var _binding: ActivityMainBinding? = null
private val binding get() = _binding!!

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pillRed.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, DayActivity::class.java)
                startActivity(intent)
            }
        })

        binding.pillBlue.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity, NightActivity::class.java)
                startActivity(intent)
            }
        })
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}