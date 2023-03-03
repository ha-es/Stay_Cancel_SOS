package com.example.stay_cancel_sos

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile_detail.*


class ProfileDetailActivity : AppCompatActivity() {
    lateinit var datas : ProfileData
    lateinit var reg_btn : Button
    lateinit var stay_btn : Button

    lateinit var scaleAnimation: ScaleAnimation
    lateinit var bounceInterpolator : BounceInterpolator
    lateinit var button_heart: CompoundButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        reg_btn = findViewById(R.id.reg_btn)
        stay_btn = findViewById(R.id.stay_btn)
        reg_btn.setClickable(false)
        stay_btn.setClickable(false)
        val type1 = "펜션"

        button_heart = findViewById(R.id.button_heart)
        button_heart.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, isChecked ->
            compoundButton.startAnimation(
                scaleAnimation
            )
        })

        /* togglebtn(button_heart) */
        scaleAnimation = ScaleAnimation(
            0.7f,
            1.0f,
            0.7f,
            1.0f,
            Animation.RELATIVE_TO_SELF,
            0.7f,
            Animation.RELATIVE_TO_SELF,
            0.7f
        )
        scaleAnimation.duration =500
        bounceInterpolator = BounceInterpolator()
        scaleAnimation.interpolator = bounceInterpolator


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