package com.lmc.volcanoweather.logic.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(val status: String, val places: List<Place>)
data class Place(val name: String, val location: Location,
                 @SerializedName("formatted_address") val address: String)//JSON中字段命名和Kotlin中命名规范不一致就用一下这个
data class Location(val lng: String, val lat: String)