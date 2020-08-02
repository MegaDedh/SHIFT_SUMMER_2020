package ru.asshands.softwire.shift_summer_2020.list.data

import ru.asshands.softwire.common.CityWeather
import ru.asshands.softwire.shift_summer_2020.list.domain.CityRepository

class CityRepositoryImpl(
    private val networkCityDataSource: NetworkCityDataSource
) : CityRepository {

    override suspend fun getCity(): List<CityWeather> = networkCityDataSource.getCity()
    override suspend fun addCity(name: String, temperature: Int) {
        TODO("fun addCityNot yet implemented")
    }
}