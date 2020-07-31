package ru.asshands.softwire.shift_summer_2020.list.domain

import ru.asshands.softwire.common.CityWeather


class GetCityUseCase(
    private val cityRepository: CityRepository
) {

    suspend operator fun invoke(): List<CityWeather> = cityRepository.getCity()
}