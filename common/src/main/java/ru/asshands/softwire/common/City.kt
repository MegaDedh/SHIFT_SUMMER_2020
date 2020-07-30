package ru.asshands.softwire.common

import java.io.Serializable


data class City(
    val id: Long,
    val name:String,
    val temperature: Int
) : Serializable