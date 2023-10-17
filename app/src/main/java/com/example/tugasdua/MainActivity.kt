package com.example.tugasdua

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.tugasdua.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtDaftarListener()
    }

    private fun txtDaftarListener(){
        binding.txtDaftardulu.setOnClickListener{ // Gunakan objek binding
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
