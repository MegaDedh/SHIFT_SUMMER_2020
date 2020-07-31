package ru.asshands.softwire.shift_summer_2020.list.domain

import ru.asshands.softwire.common.CityWeather


interface CityRepository {

    suspend fun getCity() : List<CityWeather>
}