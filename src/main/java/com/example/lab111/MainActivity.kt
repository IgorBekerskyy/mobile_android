package com.example.lab111

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var signInButton: Button? = null
    private var signUpButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signInButton = findViewById(R.id.sign_in_button)
        signUpButton = findViewById(R.id.sign_up_button)

        signInButton?.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

        signUpButton?.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}