package ru.asshands.softwire.shift_summer_2020.list.domain

import ru.asshands.softwire.common.City


class GetCityUseCase(
    private val cityRepository: CityRepository
) {

    operator fun invoke(): List<City> = cityRepository.getCity()
}