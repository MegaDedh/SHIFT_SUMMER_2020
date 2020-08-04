package ru.asshands.softwire.shift_summer_2020.list.domain

import ru.asshands.softwire.common.CityWeather


interface CityRepository {

    suspend fun getCity() : List<CityWeather>
    suspend fun getPage(start: Long, size:Int) : List<CityWeather>
    suspend fun addCity(name:String, temperature:Int)
}