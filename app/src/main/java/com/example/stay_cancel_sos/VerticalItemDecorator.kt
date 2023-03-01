package com.example.stay_cancel_sos

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/* Vertical item 간격 조정 class*/

class VerticalItemDecorator(private val divHeight : Int) : RecyclerView.ItemDecoration() {

    @Override
    override fun getItemOffsets(outRect: Rect, view: View, parent : RecyclerView, state : RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = divHeight
        outRect.bottom = divHeight
    }
}