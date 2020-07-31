package ru.asshands.softwire.server.db.table

import ru.asshands.softwire.common.CityWeather
import org.jetbrains.exposed.sql.ResultRow


fun ResultRow.toCity() = CityWeather(
    id = this[City.id],
    name = this[City.name],
    temperature = this[City.temperature]
)