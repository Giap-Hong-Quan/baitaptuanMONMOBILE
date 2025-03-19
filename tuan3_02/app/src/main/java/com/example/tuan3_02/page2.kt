package com.example.tuan3_02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnPrevPage2=findViewById<ImageView>(R.id.btnPrevPage2)

        btnPrevPage2.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java) // Chuyển đến SecondActivity
            startActivity(intent)
        }
        val btnNextPage2=findViewById<Button>(R.id.btnNextPage2)
        btnNextPage2.setOnClickListener(){
            val intent = Intent(this, page3::class.java) // Chuyển đến SecondActivity
            startActivity(intent)
        }

    }
}