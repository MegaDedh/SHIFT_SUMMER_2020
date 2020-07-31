package ru.asshands.softwire.shift_summer_2020.list.data

import ru.asshands.softwire.common.City
import ru.asshands.softwire.shift_summer_2020.list.domain.CityRepository

class CityRepositoryImpl(
    private val networkCityDataSource: NetworkCityDataSource
) : CityRepository {

    override fun getCity(): List<City> = networkCityDataSource.getCity()
}