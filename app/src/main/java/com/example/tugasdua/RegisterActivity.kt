package com.example.tugasdua

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.tugasdua.databinding.RegisterActivityBinding

class RegisterActivity : ComponentActivity() {
    private lateinit var binding: RegisterActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtLoginListener()
    }

    private fun txtLoginListener(){
        binding.txtLoginsekarang.setOnClickListener{ // Gunakan objek binding
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
