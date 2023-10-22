package com.example.tugasdua

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.tugasdua.database.AppDatabase
import com.example.tugasdua.databinding.RegisterActivityBinding

class RegisterActivity : ComponentActivity() {
    private lateinit var binding: RegisterActivityBinding
    private lateinit var db: AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        binding.btnDaftar.setOnClickListener {
            val githubUsername = binding.edtUsrgithub.text.toString()
            val email = binding.edtEmail.text.toString()
            val appUsername = binding.edtUsername.text.toString()
            val password = binding.edtPass.text.toString()

            if (githubUsername.isNotEmpty() && email.isNotEmpty() && appUsername.isNotEmpty() && password.isNotEmpty()) {
                val isSuccess = db.userDao().insertAll(githubUsername, email, appUsername, password)
                if (isSuccess.isNotEmpty()) {
                    Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "User Sudah Ada", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }
        txtLoginListener()
    }

    private fun txtLoginListener() {
        binding.txtLoginsekarang.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
