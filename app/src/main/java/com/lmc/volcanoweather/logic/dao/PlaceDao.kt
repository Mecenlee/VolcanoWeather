package com.lmc.volcanoweather.logic.dao

import android.content.Context
import android.provider.Settings.Global.putString
import androidx.core.content.edit
import com.google.gson.Gson
import com.lmc.volcanoweather.VolcanoWeatherApplication
import com.lmc.volcanoweather.logic.model.Place

object PlaceDao {
    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))//利用这个GSON将一个place对象转成一个JSON字符串再去存就很划算
        }
    }
    fun getSavedPlace(): Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }
    //判断数据是否又被存储
    fun isPlaceSaved() = sharedPreferences().contains("place")
    private fun sharedPreferences() = VolcanoWeatherApplication.context.
    getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)
}