package com.example.medicalapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    private lateinit var editEmail : EditText
    private lateinit var editPassword : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnSignUp: Button
    private lateinit var resetpass: Button
    private lateinit var view: View
    private lateinit var auth : FirebaseAuth
   // private lateinit var back : FloatingActionButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        view=findViewById(android.R.id.content)
        supportActionBar?.hide()
        resetpass =findViewById(R.id.reset)
        resetpass.setOnClickListener{
            val intent = Intent(this,ResetPasswordActivity::class.java)
            startActivity(intent)
        }
        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
       // editPassword = findViewById(R.id.Enter_Password)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignUp = findViewById(R.id.btnSignUp)
        auth= Firebase.auth
        btnSignUp.setOnClickListener{
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()
            Auth(email,password,this).log_in(view = view)



        }
//       back=findViewById(R.id.fab)
//       back.setOnClickListener{
//           finish()
//       }
         //val intent2 = Intent(this , MainActivity::class.java)

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null&& auth.currentUser!!.isEmailVerified) {
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
        }



