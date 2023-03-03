package com.example.stay_cancel_sos

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile_detail.*

class ProfileDetailActivity : AppCompatActivity() {
    lateinit var datas : ProfileData
    lateinit var reg_btn : Button
    lateinit var stay_btn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        reg_btn = findViewById(R.id.reg_btn)
        stay_btn = findViewById(R.id.stay_btn)
        reg_btn.setClickable(false)
        stay_btn.setClickable(false)


        val type1 = "펜션"

        datas = intent.getSerializableExtra("data") as ProfileData

        Glide.with(this).load(datas.img).into(img_profile)
        title_tv.text = datas.title
        price_tv.text =datas.price
        name_tv.text =datas.name
        reg_btn.text=datas.title.substring(0 until 3)
        stay_btn.text = type1
    }

    fun onCustomToogleClick(view: View) {
        Toast.makeText(this, "CustomToogle", Toast.LENGTH_SHORT).show()
    }
}