package com.example.stay_cancel_sos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pension.*
import java.text.DecimalFormat

class PensionActivity : AppCompatActivity(){
    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileData>()

    /* 천단위 콤마(,) 넣기 위한 코드*/
    val dec = DecimalFormat("#,###")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pension)

        initRecycler()
        rv_profile.addItemDecoration(VerticalItemDecorator(20))
        rv_profile.addItemDecoration(HorizontalItemDecorator(10))
    }
    private fun initRecycler() {
        profileAdapter = ProfileAdapter(this)
        rv_profile.adapter = profileAdapter


        datas.apply {
            add(ProfileData(img = R.drawable.pension_img, name = "부산갈매기", price = dec.format(30000), title = "부산 웅앵웅앵"))
            add(ProfileData(img = R.drawable.pension_img, name = "부산갈매기", price = dec.format(30000), title = "부산 웅앵웅앵"))
            add(ProfileData(img = R.drawable.pension_img, name = "부산갈매기", price = dec.format(30000), title = "부산 웅앵웅앵"))
            add(ProfileData(img = R.drawable.pension_img, name = "부산갈매기", price = dec.format(30000), title = "부산 웅앵웅앵"))
            add(ProfileData(img = R.drawable.pension_img, name = "부산갈매기", price = dec.format(30000), title = "부산 웅앵웅앵"))
            add(ProfileData(img = R.drawable.pension_img, name = "부산갈매기", price = dec.format(30000), title = "부산 웅앵웅앵"))
            add(ProfileData(img = R.drawable.pension_img, name = "부산갈매기", price = dec.format(30000), title = "부산 웅앵웅앵"))
            add(ProfileData(img = R.drawable.pension_img, name = "부산갈매기", price = dec.format(30000), title = "부산 웅앵웅앵"))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()

        }
    }
}