package com.example.omar.manasattask.ui.details

import com.bumptech.glide.Glide
import com.example.omar.manasattask.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.details_item.view.*
import android.opengl.ETC1.getHeight



class DetailsItem(val uri:String): Item<ViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.details_item
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val v = viewHolder.itemView
        Glide.with(v).load(uri).into(v.person_image)
        val cellHeight = v.getHeight()
    }

}