package ru.asshands.softwire.server.db.table

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Cities : Table() {
    val id: Column<Long> = Cities.long("id").autoIncrement().primaryKey()
    val name: Column<String> = Cities.text("name")
    val temperature: Column<Int> = Cities.integer("temperature")
}