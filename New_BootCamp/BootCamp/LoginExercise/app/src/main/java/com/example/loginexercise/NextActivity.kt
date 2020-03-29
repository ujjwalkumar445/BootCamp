package com.example.loginexercise

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {
    var Email: String = "EMAILID"
    var Password: String = "PASSWORD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        val textview_email = findViewById<TextView>(R.id.email)
        val textView_password = findViewById<TextView>(R.id.password)
        val email = intent.getStringExtra(Email)
        val password = intent.getStringExtra(Password)


        textview_email.text = email
        textView_password.text = password


    }
}