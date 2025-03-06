package com.example.thuahanh1

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultAge : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_age)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ageText = findViewById<TextView>(R.id.age)
        val age = intent.getIntExtra("AGE_KEY", 0)
        // Gán kết quả của when vào biến message
        val message = when {
            age >65 -> "Người Già"
            age in 6..65 -> "Người Lớn"
            age in 2..6 -> "Trẻ Em"
            age >= 0 -> "Em Bé"
            else -> "Không hợp lệ"
        }
        // Hiển thị kết quả trên UI
        ageText.text = "Tuổi: $age\n$message"

    }
}