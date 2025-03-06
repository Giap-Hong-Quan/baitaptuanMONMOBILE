package com.example.thuahanh1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val btn = findViewById<Button>(R.id.btn)
        val name = findViewById<EditText>(R.id.inputname)
        val ageInput = findViewById<EditText>(R.id.inputage)

        btn.setOnClickListener {
            val userName = name.text.toString().trim()
            val age = ageInput.text.toString().trim().toIntOrNull() // Chuyển đổi thành Int, kiểm tra null

            if (userName.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (age == null) {
                Toast.makeText(this, "Vui lòng nhập số tuổi hợp lệ", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultAge::class.java)
            intent.putExtra("AGE_KEY", age) // Gửi tuổi qua trang ResultAge
            startActivity(intent)
        }



    }
}

