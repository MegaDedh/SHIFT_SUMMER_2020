package ru.asshands.softwire.shift_summer_2020.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherParams(
    val temperature: Float,
    val humidity: Int,
    val windSpeed: Int
) : Parcelable