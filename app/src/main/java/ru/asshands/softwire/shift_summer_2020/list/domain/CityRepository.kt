package ru.asshands.softwire.shift_summer_2020.list.domain

import ru.asshands.softwire.common.City


interface CityRepository {

    fun getCity() : List<City>
}