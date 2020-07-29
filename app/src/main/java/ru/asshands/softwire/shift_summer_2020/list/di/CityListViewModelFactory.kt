package ru.asshands.softwire.shift_summer_2020.list.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.asshands.softwire.shift_summer_2020.list.data.CityRepositoryImpl
import ru.asshands.softwire.shift_summer_2020.list.data.NetworkCityDataSourceImpl
import ru.asshands.softwire.shift_summer_2020.list.domain.GetCityUseCase
import ru.asshands.softwire.shift_summer_2020.list.presentation.CityListViewModel


class CityListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == CityListViewModel::class.java) {
            val networkDataSource = NetworkCityDataSourceImpl()
            val cityRepository = CityRepositoryImpl(networkDataSource)
            val getCityUseCase = GetCityUseCase(cityRepository)

            return CityListViewModel(getCityUseCase) as T
        } else {
            error("Unexpected class $modelClass")
        }
    }
}