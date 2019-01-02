package com.example.omar.manasattask.ui.main

import com.bumptech.glide.Glide
import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.R
import com.example.omar.manasattask.models.PopularPerson
import com.xwray.groupie.Group
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.popular_person_item.view.*

class PersonItem(val person: PopularPerson): Item<ViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.popular_person_item
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val v = viewHolder.itemView
        Glide.with(v).load(person.imageUri).into(v.profile_image)
        v.name_txt_view.text = person.name
        v.popularity_txt_view.text = "" + person.popularity
    }
}