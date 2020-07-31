package ru.asshands.softwire.shift_summer_2020.list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.asshands.softwire.common.CityWeather
import ru.asshands.softwire.shift_summer_2020.list.domain.GetCityUseCase
import ru.asshands.softwire.shift_summer_2020.utils.viewmodel.SingleLiveEvent

class CityListViewModel (getCityUseCase: GetCityUseCase): ViewModel() {

    val city = MutableLiveData<List<CityWeather>>()
    val cityClickedEvent = SingleLiveEvent<CityWeather>()

    init {
        city.value = getCityUseCase()
    }

    fun cityClicked(city: CityWeather) {
        cityClickedEvent(city)
    }
}