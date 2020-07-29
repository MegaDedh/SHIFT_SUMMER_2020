package ru.asshands.softwire.shift_summer_2020.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(val name:String, val weather: Weather) : Parcelable