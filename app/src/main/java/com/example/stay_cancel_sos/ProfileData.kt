package com.example.stay_cancel_sos

import android.graphics.drawable.Drawable
import java.io.Serializable

data class ProfileData(
    val name : String,
    val title : String,
    val price : String,
    val img : Int
): Serializable
