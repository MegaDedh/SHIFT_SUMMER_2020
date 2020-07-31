package ru.asshands.softwire.shift_summer_2020.list.domain

import ru.asshands.softwire.common.CityWeather


interface CityRepository {

    fun getCity() : List<CityWeather>
}