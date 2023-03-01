package com.example.stay_cancel_sos

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/* Horizontal item 간격 조정 class*/

class HorizontalItemDecorator(private val divHeight : Int) : RecyclerView.ItemDecoration() {

    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent : RecyclerView, state : RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = divHeight
        outRect.right = divHeight
    }
}