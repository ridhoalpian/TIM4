package com.example.tugasdua

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.tugasdua.database.DatabaseHelper
import com.example.tugasdua.databinding.RegisterActivityBinding

class RegisterActivity : ComponentActivity() {
    private lateinit var binding: RegisterActivityBinding
    private lateinit var db: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DatabaseHelper(this)

        binding.btnDaftar.setOnClickListener {
            val usernameGithub = binding.edtUsrgithub.text.toString()
            val email = binding.edtEmail.text.toString()
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPass.text.toString()

            if (usernameGithub.isNotEmpty() &&  email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty()) {
                val isSuccess = db.insertdata(usernameGithub, email, username, password)
                if (isSuccess) {
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


    private fun txtLoginListener(){
        binding.txtLoginsekarang.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
