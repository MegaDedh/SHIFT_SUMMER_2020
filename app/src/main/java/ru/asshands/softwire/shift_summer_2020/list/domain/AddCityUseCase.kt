package ru.asshands.softwire.shift_summer_2020.list.domain

import ru.asshands.softwire.common.CityWeather


class AddCityUseCase(
    private val cityRepository: CityRepository
) {

    suspend operator fun invoke(name:String, temperature:Int) = cityRepository.addCity(name,temperature)
}