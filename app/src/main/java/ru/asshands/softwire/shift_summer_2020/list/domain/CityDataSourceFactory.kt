package ru.asshands.softwire.shift_summer_2020.list.domain

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

import kotlinx.coroutines.CoroutineScope
import ru.asshands.softwire.common.CityWeather

class CityDataSourceFactory(
    private val repository: CityRepository,
    private val coroutineScope: CoroutineScope
) : DataSource.Factory<Long, CityWeather>() {

    private val liveDataSource = MutableLiveData<CityItemKeyedDataSource>()

    override fun create(): DataSource<Long, CityWeather> {
        val source =
            CityItemKeyedDataSource(
                repository,
                coroutineScope
            )
        liveDataSource.postValue(source)
        return source
    }
}