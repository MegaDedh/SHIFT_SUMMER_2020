package ru.asshands.softwire.common

import java.io.Serializable

data class CreateCityDto(
    val name:String,
    val temperature: Int
) : Serializable