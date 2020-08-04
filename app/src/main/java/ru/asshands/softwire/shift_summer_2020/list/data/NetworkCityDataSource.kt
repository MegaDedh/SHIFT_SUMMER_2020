package ru.asshands.softwire.shift_summer_2020.list.data


import ru.asshands.softwire.common.CityWeather
import ru.asshands.softwire.common.Weather

interface NetworkCityDataSource {

    suspend fun getCity(): List<CityWeather>

    suspend fun getPage(start: Long, size: Int): List<CityWeather>
}

class NetworkCityDataSourceImpl(private val api: CityWeatherApi) : NetworkCityDataSource {

    override suspend fun getCity(): List<CityWeather> = api.getAll()

    override suspend fun getPage(start: Long, size: Int) =
        api.getPage(start, size)

}