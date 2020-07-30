package ru.asshands.softwire.server.db.table

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object City : Table() {
    val id: Column<Long> = City.long("id").autoIncrement().primaryKey()
    val name: Column<String> = City.text("name")
    val temperature: Column<Int> = City.integer("temperature")
}