package ru.asshands.softwire.shift_summer_2020.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityWeather(val name:String, val weather: WeatherParams) : Parcelable