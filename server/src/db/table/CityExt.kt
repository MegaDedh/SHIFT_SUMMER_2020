package ru.asshands.softwire.server.db.table

import ru.asshands.softwire.common.City
import org.jetbrains.exposed.sql.ResultRow


fun ResultRow.toCity() = City(
    id = this[City.id],
    name = this[City.name],
    temperature = this[City.temperature]
)