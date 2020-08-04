package ru.asshands.softwire.shift_summer_2020.list.presentation

import androidx.recyclerview.widget.DiffUtil
import ru.asshands.softwire.common.CityWeather

class CityDiffUtilCallback : DiffUtil.ItemCallback<CityWeather>() {
    override fun areItemsTheSame(oldItem: CityWeather, newItem: CityWeather) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CityWeather, newItem: CityWeather) =
        oldItem.name == newItem.name && oldItem.temperature == newItem.temperature
}