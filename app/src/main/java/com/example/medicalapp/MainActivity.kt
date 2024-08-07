package com.example.medicalapp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // private lateinit var registBtn : Button
    private lateinit var loginBtn : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // registBtn = findViewById(R.id.regBtn)
       loginBtn = findViewById(R.id.logBtn)
//     registBtn.setOnClickListener{
////            val intent = Intent(this , SignUp::class.java)
////            startActivity(intent)
////
////
////        }
    loginBtn.setOnClickListener{
           val intent = Intent(this ,LoginActivity::class.java)
            startActivity(intent)
        }

    }


}