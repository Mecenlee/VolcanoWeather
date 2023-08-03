package com.lmc.volcanoweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.lmc.volcanoweather.logic.Repository
import com.lmc.volcanoweather.logic.model.Place
//ViewModel层
class PlaceViewModel:ViewModel() {
    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
    fun savePlace(place: Place) = Repository.savePlace(place)
    fun getSavedPlace() = Repository.getSavedPlace()
    fun isPlaceSaved() = Repository.isPlaceSaved()
}