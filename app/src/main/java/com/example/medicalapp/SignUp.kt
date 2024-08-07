package com.example.medicalapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class SignUp  : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editEmail : EditText
    lateinit var editPassword : EditText
    private lateinit var btnSignUp: Button
    private lateinit var view: View
    private lateinit var backbtn : FloatingActionButton
   // private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        supportActionBar?.hide()
        //Auth = FirebaseAuth.getInstance()
        view = findViewById(android.R.id.content)
        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.Enter_Password)
        editName = findViewById(R.id.edit_name)
        btnSignUp = findViewById(R.id.btnSignUp)
        btnSignUp.setOnClickListener {
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()
            val name: String = editName.text.toString()
            Auth(email, password, this).signup(view, name)

        val intent2 =Intent(this , LoginActivity::class.java)
            startActivity(intent2)

        }
        backbtn = findViewById(R.id.fab2)
        backbtn.setOnClickListener {

            val intent3 = Intent(this , LoginActivity::class.java)
            startActivity(intent3)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }}

