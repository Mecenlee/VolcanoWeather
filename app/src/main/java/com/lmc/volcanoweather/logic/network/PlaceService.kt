package com.lmc.volcanoweather.logic.network

import com.lmc.volcanoweather.VolcanoWeatherApplication
import com.lmc.volcanoweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
//位置服务
interface PlaceService {
    //发送的网络请求只有query(地址)，其他的都不会变
    @GET("v2/place?token=${VolcanoWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String):Call<PlaceResponse>//讲数据返回结果解析成PlaceResponse
}