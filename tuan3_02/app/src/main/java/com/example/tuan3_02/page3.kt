package com.example.tuan3_02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class page3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnPrevPage3=findViewById<ImageView>(R.id.btnPrevPage3)

        btnPrevPage3.setOnClickListener(){
            val intent = Intent(this, page2::class.java) // Chuyển đến SecondActivity
            startActivity(intent)
        }
        val btnNextPage3=findViewById<Button>(R.id.btnNextPage3)
        btnNextPage3.setOnClickListener(){
            val intent = Intent(this, page4::class.java) // Chuyển đến SecondActivity
            startActivity(intent)
        }
    }
}