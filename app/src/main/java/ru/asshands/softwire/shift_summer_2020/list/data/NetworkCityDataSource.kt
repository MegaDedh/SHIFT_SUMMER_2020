package ru.asshands.softwire.shift_summer_2020.list.data


import ru.asshands.softwire.common.CityWeather
import ru.asshands.softwire.common.Weather

interface NetworkCityDataSource {

    suspend fun getCity(): List<CityWeather>
}

class NetworkCityDataSourceImpl(private val api: CityWeatherApi) : NetworkCityDataSource {

    override suspend fun getCity(): List<CityWeather> = api.getAll()

}
        /*listOf(
            CityWeather(1,"Томск", 20),
            CityWeather(2,"Новосибирск", 25),
            CityWeather(3,"Москва", 23),
            CityWeather(4,"Краснодар", 41),
            CityWeather(5,"Сургут", -45),
            CityWeather(6,"Воркута", -45),
            CityWeather(7,"Магадан", -55),
            CityWeather(8,"Якутск", -60))*/
