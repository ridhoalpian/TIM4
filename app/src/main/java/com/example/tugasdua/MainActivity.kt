package com.example.tugasdua

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.tugasdua.database.AppDatabase
import com.example.tugasdua.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        binding.btnMasuk.setOnClickListener {
            val username = binding.edtUser.text.toString()
            val password = binding.edtPass.text.toString()

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Harap isi username dan password", Toast.LENGTH_SHORT).show()
            } else {
                val checkedUsers = db.userDao().checkUserPass(username, password)

                if (checkedUsers.isNotEmpty()) {
                    Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SplashScreenActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Login gagal. Periksa kredensial Anda.", Toast.LENGTH_SHORT).show()
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
