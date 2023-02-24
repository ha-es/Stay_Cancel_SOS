package com.example.stay_cancel_sos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    // 로그인
    lateinit var email: TextView
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 로그인
        auth = FirebaseAuth.getInstance()
        email = findViewById(R.id.email_tv)
        email.text = auth.currentUser?.email

    }

}