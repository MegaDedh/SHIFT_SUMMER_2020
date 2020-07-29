package ru.asshands.softwire.shift_summer_2020.list.data

import ru.asshands.softwire.shift_summer_2020.domain.entity.City
import ru.asshands.softwire.shift_summer_2020.domain.entity.Weather

interface NetworkCityDataSource {

    fun getCity(): List<City>
}

class NetworkCityDataSourceImpl : NetworkCityDataSource {

    override fun getCity(): List<City> =
        listOf(
            City("Томск", Weather(20.6f, 70, 3)),
            City("Новосибирск", Weather(25.4f, 60, 5)),
            City("Москва", Weather(23.4f, 55, 7)),
            City("Краснодар", Weather(41f, 63, 10)),
            City("Сургут", Weather(-45.3f, 40, 8)),
            City("Воркута", Weather(-45.3f, 40, 14)),
            City("Магадан", Weather(-55.3f, 57, 17)),
            City("Якутск", Weather(-65.3f, 60, 20))
        )
}