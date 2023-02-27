package com.example.stay_cancel_sos

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var email: TextView
    lateinit var name : TextView
    lateinit var auth:FirebaseAuth
    lateinit var chat_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        chat_btn = findViewById(R.id.chat_btn)
        chat_btn.setOnClickListener {
            var intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
        auth = FirebaseAuth.getInstance()
        email = findViewById(R.id.email_tv)

        email.text = auth.currentUser?.email






    }
}