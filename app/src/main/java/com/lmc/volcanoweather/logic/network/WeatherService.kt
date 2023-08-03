package com.lmc.volcanoweather.logic.network

import com.lmc.volcanoweather.VolcanoWeatherApplication
import com.lmc.volcanoweather.logic.model.DailyResponse
import com.lmc.volcanoweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("v2.5/${VolcanoWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String):
            Call<RealtimeResponse>

    @GET("v2.5/${VolcanoWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String):
            Call<DailyResponse>
}