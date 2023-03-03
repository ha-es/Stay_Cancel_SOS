package com.example.stay_cancel_sos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class LoginActivity : AppCompatActivity() {
    lateinit var emailEt: EditText
    lateinit var passwordEt: EditText
    lateinit var loginBtn: Button
    lateinit var joinBtn: Button
    lateinit var go_main: Button

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        emailEt = findViewById(R.id.Email_et)
        passwordEt = findViewById(R.id.Pwd_et)
        loginBtn = findViewById(R.id.button)
        joinBtn = findViewById(R.id.join_btn)

        /* 로그인 없이 메인 이동 */
        go_main = findViewById(R.id.go_main)

        loginBtn.setOnClickListener {
            var email = emailEt.text.toString()
            var password = passwordEt.text.toString()

            if(email.isEmpty() || password.isEmpty())
            {
                Toast.makeText(this,"아이디와 비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show()
            }
            else{
                login(email,password)
            }

        }


        joinBtn.setOnClickListener {
            var intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }


        /* 로그인 없이 메인 이동 */
        go_main.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


//        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
//        val myRef: DatabaseReference = database.getReference("message")
//        myRef.setValue("hello")
    }

    fun login(email:String,password:String){
        auth.signInWithEmailAndPassword(email,password) // 로그인
            .addOnCompleteListener {
                    result->
                if(result.isSuccessful){
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    //틀렸을 때
                    //Toast.makeText(this,result.exception?.message,Toast.LENGTH_SHORT).show()
                    Toast.makeText(this,"아이디와 비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show()
                    }

            }
    }
}