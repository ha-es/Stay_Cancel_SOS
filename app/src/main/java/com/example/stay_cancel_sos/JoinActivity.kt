package com.example.stay_cancel_sos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class JoinActivity : AppCompatActivity() {

    lateinit var emailEt: EditText
    lateinit var passwordEt: EditText
    lateinit var nameEt: EditText
    lateinit var phoneNumEt: EditText
    //생년월일 추가 예정
    lateinit var join_btn: Button
    lateinit var auth: FirebaseAuth


    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        auth = FirebaseAuth.getInstance()


        emailEt = findViewById(R.id.Email_et)
        passwordEt = findViewById(R.id.Pwd_et)
        nameEt = findViewById(R.id.Name_et)
        phoneNumEt = findViewById(R.id.Phonenum_edt)
        join_btn = findViewById(R.id.join_btn)


        join_btn.setOnClickListener {
            var email = emailEt.text.toString()
            var password = passwordEt.text.toString()
            var name = nameEt.text.toString()
            var phoneNum = phoneNumEt.text.toString()
            val user = FirebaseAuth.getInstance().currentUser
            val db = FirebaseFirestore.getInstance()

            auth.createUserWithEmailAndPassword(email,password) // 회원 가입
                .addOnCompleteListener {
                        result ->
                    if(result.isSuccessful){
                        Toast.makeText(this,"회원가입이 완료되었습니다.",Toast.LENGTH_SHORT).show()
                        if(auth.currentUser!=null){
                            var intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            db.collection("user").document("user.toString()")
                        }
                    } else if(result.exception?.message.isNullOrEmpty()){
                        Toast.makeText(this,"오류가 발생했습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}

