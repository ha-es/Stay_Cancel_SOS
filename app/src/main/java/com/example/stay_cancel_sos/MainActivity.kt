package com.example.stay_cancel_sos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var email: TextView
    lateinit var auth:FirebaseAuth
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        email = findViewById(R.id.email_tv)
        button = findViewById(R.id.logout_btn)
        email.text = auth.currentUser?.email

        button.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
        }

    }
}