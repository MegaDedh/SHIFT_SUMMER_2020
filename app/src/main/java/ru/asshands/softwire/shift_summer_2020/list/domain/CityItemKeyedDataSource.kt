package ru.asshands.softwire.shift_summer_2020.list.domain

import androidx.paging.ItemKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.asshands.softwire.common.CityWeather

class CityItemKeyedDataSource(
    private val repository: CityRepository,
    private val coroutineScope: CoroutineScope
) : ItemKeyedDataSource<Long, CityWeather>() {
    override fun getKey(item: CityWeather): Long = item.id


    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<CityWeather>) {
        coroutineScope.launch {
            val start = params.key
            val size = params.requestedLoadSize
            val city = repository.getPage(start, size)
            callback.onResult(city)
        }

    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<CityWeather>) {
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<CityWeather>
    ) {
        coroutineScope.launch {
            val size = params.requestedLoadSize
            val city = repository.getPage(0, size)
            callback.onResult(city)
        }
    }
}