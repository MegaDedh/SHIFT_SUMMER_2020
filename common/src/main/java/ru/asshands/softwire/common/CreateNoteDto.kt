package ru.asshands.softwire.common

import java.io.Serializable

data class CreateNoteDto(
    val title: String,
    val description: String
) : Serializable