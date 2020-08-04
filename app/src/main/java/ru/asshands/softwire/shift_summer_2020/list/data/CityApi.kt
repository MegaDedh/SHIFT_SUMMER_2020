package ru.asshands.softwire.shift_summer_2020.list.data

import retrofit2.http.GET
import retrofit2.http.Query
import ru.asshands.softwire.common.CityWeather

interface CityWeatherApi {
    @GET("/city")
    suspend fun getAll(): List<CityWeather>

    @GET("/city")
    suspend fun getPage(
        @Query("start") start: Long,
        @Query("size") size: Int
    ): List<CityWeather>
}