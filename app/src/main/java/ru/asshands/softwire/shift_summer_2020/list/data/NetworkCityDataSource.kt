package ru.asshands.softwire.shift_summer_2020.list.data


import ru.asshands.softwire.common.City
import ru.asshands.softwire.common.Weather

interface NetworkCityDataSource {

    fun getCity(): List<City>
}

class NetworkCityDataSourceImpl : NetworkCityDataSource {

    override fun getCity(): List<City> =
        listOf(
            City(1,"Томск", 20),
            City(2,"Новосибирск", 25),
            City(3,"Москва", 23),
            City(4,"Краснодар", 41),
            City(5,"Сургут", -45),
            City(6,"Воркута", -45),
            City(7,"Магадан", -55),
            City(8,"Якутск", -60))

}