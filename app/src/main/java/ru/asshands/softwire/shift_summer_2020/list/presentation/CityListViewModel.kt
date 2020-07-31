package ru.asshands.softwire.shift_summer_2020.list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.asshands.softwire.common.CityWeather
import ru.asshands.softwire.shift_summer_2020.list.domain.GetCityUseCase
import ru.asshands.softwire.shift_summer_2020.utils.viewmodel.SingleLiveEvent

class CityListViewModel (getCityUseCase: GetCityUseCase): ViewModel() {

    val city = MutableLiveData<List<CityWeather>>()
    val cityClickedEvent = SingleLiveEvent<CityWeather>()

    init {
        viewModelScope.launch {
            try {
                city.value = getCityUseCase()
            } catch (e: Exception) {
                // show error
            }
        }
    }

    fun cityClicked(city: CityWeather) {
        cityClickedEvent(city)
    }
}