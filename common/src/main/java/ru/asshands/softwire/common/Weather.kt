package ru.asshands.softwire.common

import java.io.Serializable

data class Weather(
    val temperature: Float,
    val humidity: Int,
    val windSpeed: Int
) : Serializable