package com.example.loginexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var Email : String = "EMAILID"
    var Password : String = "PASSWORD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edemail = findViewById<EditText>(R.id.edemail)
        val edpassword = findViewById<EditText>(R.id.edpassword)
        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener(View.OnClickListener {
            intent = Intent(this,NextActivity::class.java)
            intent.putExtra(Email,edemail.text.toString())
            intent.putExtra(Password,edpassword.text.toString())
            startActivity(intent)
        })
    }
}


