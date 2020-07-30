package ru.asshands.softwire.server

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import ru.asshands.softwire.server.repository.CityRepository

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        get("/city") {
            //call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
            val repository: CityRepository = CityRepository()
            val city = repository.getAll()
            call.respond(city)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

