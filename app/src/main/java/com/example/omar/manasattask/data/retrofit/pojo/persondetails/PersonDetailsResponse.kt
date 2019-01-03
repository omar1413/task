package com.example.omar.manasattask.data.retrofit.pojo.persondetails

import com.google.gson.annotations.SerializedName

data class PersonDetailsResponse(
    val id: Int,
    val name: String,
    @SerializedName("also_known_as") val knownIn: String,
    val biography: String,
    val popularity: Double,
    @SerializedName("place_of_birth") val placeOfBirth: String
)