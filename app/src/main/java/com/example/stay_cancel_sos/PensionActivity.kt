package com.example.stay_cancel_sos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
            add(ProfileData(img = R.drawable.img, name = "부산갈매기", price = dec.format(330000), title = "부산 \n" + "송정 폴마레 풀빌라 펜션"))
            add(ProfileData(img = R.drawable.img2, name = "한옥love", price = dec.format(380000), title = "강릉 \n" + "독채 한옥 펜션"))
            add(ProfileData(img = R.drawable.img, name = "부산갈매기", price = dec.format(330000), title = "거제도 \n" + "송정 폴마레 풀빌라 펜션"))
            add(ProfileData(img = R.drawable.img2, name = "한옥love", price = dec.format(380000), title = "대한민국\n" + "독채 한옥 펜션"))
            add(ProfileData(img = R.drawable.img, name = "부산갈매기", price = dec.format(330000), title = "부산 \n" + "송정 폴마레 풀빌라 펜션"))
            add(ProfileData(img = R.drawable.img2, name = "한옥love", price = dec.format(380000), title = "강릉 \n" + "독채 한옥 펜션"))
            add(ProfileData(img = R.drawable.img, name = "부산갈매기", price = dec.format(330000), title = "부산 \n" + "송정 폴마레 풀빌라 펜션"))
            add(ProfileData(img = R.drawable.img2, name = "한옥love", price = dec.format(380000), title = "강릉 \n" + "독채 한옥 펜션"))


            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()

        }
    }
}