package ru.asshands.softwire.server.db.table

import org.jetbrains.exposed.sql.ResultRow
import ru.asshands.softwire.common.Note

fun ResultRow.toNote() = Note(
    id = this[Notes.id],
    title = this[Notes.title],
    description = this[Notes.description]
)