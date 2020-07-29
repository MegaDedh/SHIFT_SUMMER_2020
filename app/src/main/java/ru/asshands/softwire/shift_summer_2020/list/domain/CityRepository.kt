package ru.asshands.softwire.shift_summer_2020.list.domain

import ru.asshands.softwire.shift_summer_2020.domain.entity.City


interface CityRepository {

    fun getCity() : List<City>
}