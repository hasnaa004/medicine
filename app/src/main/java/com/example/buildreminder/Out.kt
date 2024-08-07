package com.example.buildreminder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.medicine.R

class Out : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_out)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val singOut = findViewById<Button>(R.id.btnSignOut)
        singOut.setOnClickListener {
            finishAffinity()
        }

        val addMedicine = findViewById<Button>(R.id.btnAddMedicine)
        addMedicine.setOnClickListener {
            val intent3 = Intent(this, Data::class.java)
            startActivity(intent3)
        }
    }
}