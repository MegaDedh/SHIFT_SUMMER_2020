package ru.asshands.softwire.server.db.table

import ru.asshands.softwire.common.City
import org.jetbrains.exposed.sql.ResultRow


fun ResultRow.toCity() = City(
    id = this[Cities.id],
    name = this[Cities.name],
    temperature = this[Cities.temperature]
)