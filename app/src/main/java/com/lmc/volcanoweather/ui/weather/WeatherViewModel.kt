package com.lmc.volcanoweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.lmc.volcanoweather.logic.Repository
import com.lmc.volcanoweather.logic.model.Location

class WeatherViewModel : ViewModel() {
    private val locationLiveData = MutableLiveData<Location>()
    //下面三个都是和界面相关的数据，所以放在 ViewModel
    var locationLng = ""
    var locationLat = ""
    var placeName = ""
    //这个是转换LiveData观察用的
    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }
}