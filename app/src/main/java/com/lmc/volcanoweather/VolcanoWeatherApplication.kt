package com.lmc.volcanoweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
//全局获取context
class VolcanoWeatherApplication:Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        //天气API的令牌值
        const val TOKEN = "NL0AtaDgGQO3Ytfg"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}