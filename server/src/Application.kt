package ru.asshands.softwire.server

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import ru.asshands.softwire.server.db.DatabaseFactory
import ru.asshands.softwire.server.repository.CityRepository
import ru.asshands.softwire.server.repository.NoteRepository
import java.net.URI

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    val dbUri = URI(environment.config.property("db.jdbcUrl").getString())

    val username: String = dbUri.userInfo.split(":")[0]
    val password: String = dbUri.userInfo.split(":")[1]
    val dbUrl = ("jdbc:postgresql://${dbUri.host}:${dbUri.port}${dbUri.path}")

    DatabaseFactory(
        dbUrl = dbUrl,
        dbPassword = password,
        dbUser = username
    ).apply {
        init()
    }

    //val repository = CityRepository()
    val repository = NoteRepository()

    routing {
        get("/notes") {
            // call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)

            val notes = repository.getAll()
            call.respond(notes)

//            val city = repository.getAll()
//            call.respond(city)
        }

/*        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }*/
    }
}

