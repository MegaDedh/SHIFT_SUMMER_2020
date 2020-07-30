package ru.asshands.softwire.server.repository

import ru.asshands.softwire.common.City
import ru.asshands.softwire.common.Weather

class CityRepository {
    fun getAll() =
        listOf(
            City("Томск", Weather(20.6f, 70, 3)),
            City("Новосибирск", Weather(25.4f, 60, 5)),
            City("Москва", Weather(23.4f, 55, 7)),
            City("Краснодар", Weather(41f, 63, 10)),
            City("Сургут", Weather(-45.3f, 40, 8)),
            City("Воркута", Weather(-45.3f, 40, 14)),
            City("Магадан", Weather(-55.3f, 57, 17)),
            City("Якутск", Weather(-65.3f, 60, 20)),
            City("Хабаровск", Weather(20.3f, 60, 20)),
            City("Владивосток", Weather(20.3f, 60, 20)),
            City("Тюмень", Weather(20.3f, 60, 20)),
            City("Самара", Weather(35.7f, 60, 9))
        )
}