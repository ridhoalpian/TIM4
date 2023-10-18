package com.example.tugasdua

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.tugasdua.database.DatabaseHelper
import com.example.tugasdua.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DatabaseHelper(this)

        binding.btnMasuk.setOnClickListener {
            val username = binding.edtUser.text.toString()
            val password = binding.edtPass.text.toString()


            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Add username && Password", Toast.LENGTH_SHORT).show()
            } else {
                val checkuser = db.checkuserpass(username, password)
                if (checkuser == true) {
                    Toast.makeText(this, "Login Succes", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SplashScreenActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "Login gagal. Periksa kredensial Anda.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        txtDaftarListener()
    }

    private fun txtDaftarListener(){
        binding.txtDaftardulu.setOnClickListener{ // Gunakan objek binding
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
