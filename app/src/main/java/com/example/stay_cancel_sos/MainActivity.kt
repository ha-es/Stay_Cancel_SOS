package com.example.stay_cancel_sos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.stay_cancel_sos.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var email: TextView
    lateinit var name : TextView
    lateinit var logout_btn : Button

    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        /*하단 nav*/
        initBinding()
        initNavigation()

//        chat_btn = findViewById(R.id.chat_btn)
//        chat_btn.setOnClickListener {
//            var intent = Intent(this, ChatActivity::class.java)
//            startActivity(intent)
//        }
//
//        pension_btn = findViewById(R.id.pension_btn)
//        pension_btn.setOnClickListener {
//            var intent = Intent(this, PensionActivity::class.java)
//            startActivity(intent)
//        }
        auth = FirebaseAuth.getInstance()
        email = findViewById(R.id.email_tv)
        email.text = auth.currentUser?.email

        logout_btn = findViewById(R.id.logout_btn)
        logout_btn.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initNavigation() {
        NavigationUI.setupWithNavController(binding.navBar, findNavController(R.id.nav_host))
    }
}