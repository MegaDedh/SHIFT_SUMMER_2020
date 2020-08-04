package ru.asshands.softwire.shift_summer_2020.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Config
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import ru.asshands.softwire.common.CityWeather
import ru.asshands.softwire.shift_summer_2020.list.domain.CityDataSourceFactory
import ru.asshands.softwire.shift_summer_2020.list.domain.CityRepository
import ru.asshands.softwire.shift_summer_2020.utils.viewmodel.SingleLiveEvent

class CityListViewModel(cityRepository: CityRepository) : ViewModel() {


    val cityClickedEvent = SingleLiveEvent<CityWeather>()

    private val factory = CityDataSourceFactory(cityRepository, viewModelScope)
    private val config = Config(
        pageSize = 10,
        prefetchDistance = 1,
        enablePlaceholders = false
    )
    val city: LiveData<PagedList<CityWeather>> = LivePagedListBuilder(factory, config).build()

//    old version:
//    init {
//        viewModelScope.launch {
//            try {
//                city.value = getCityUseCase()
//            } catch (e: Exception) {
//                // show error
//            }
//        }
//    }

    fun cityClicked(city: CityWeather) {
        cityClickedEvent(city)
    }
}