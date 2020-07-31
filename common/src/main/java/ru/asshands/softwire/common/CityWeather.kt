package ru.asshands.softwire.common

import java.io.Serializable


data class CityWeather(
    val id: Long,
    val name:String,
    val temperature: Int
) : Serializable