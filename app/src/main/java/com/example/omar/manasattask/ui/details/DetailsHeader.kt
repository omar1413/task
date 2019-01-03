package com.example.omar.manasattask.ui.details

import com.bumptech.glide.Glide
import com.example.omar.manasattask.BuildConfig
import com.example.omar.manasattask.R
import com.example.omar.manasattask.data.retrofit.pojo.persondetails.PersonDetailsResponse
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.details_header.view.*

class DetailsHeader(val personDetails: PersonDetailsResponse): Item<ViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.details_header
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        val v = viewHolder.itemView
        Glide.with(v).load(BuildConfig.Base_IMAGE_URL + personDetails.profilePath).into(v.profile_image)
        v.name_txt_view.text = personDetails.name
        v.popularity_txt_view.text = personDetails.popularity.toString()
        v.biography_txt_view.text = personDetails.biography
        v.place_of_pirth_txt_view.text = personDetails.placeOfBirth
    }

}