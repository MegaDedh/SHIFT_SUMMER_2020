package ru.asshands.softwire.server

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.features.*
import ru.asshands.softwire.common.CreateCityDto
import ru.asshands.softwire.server.db.DatabaseFactory
import ru.asshands.softwire.server.repository.CityRepository
import java.net.URI

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
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

    val repository = CityRepository()


    routing {
        route("/city") {
            get {
                val start = call.request.queryParameters["start"]?.toLong()
                val size = call.request.queryParameters["size"]?.toInt()
                if (start == null || size == null){
                val city = repository.getAll()
                call.respond(city)
                } else {
                    val city = repository.getPage(start, size)
                    call.respond(city)
                }
            }
            post {
                val city = call.receive<CreateCityDto>()
                repository.add(city)
                call.respond(HttpStatusCode.OK)
            }
            delete {
                val id = call.request.queryParameters["id"]?.toLong()
                if (id == null) {
                    call.respond(HttpStatusCode.NotFound)
                } else {
                    repository.delete(id)
                    call.respond(HttpStatusCode.OK)
                }
            }
        }
    }
}


/*
старый
routing {
    get("/city") {
        // call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        val city = repository.getAll()
        call.respond(city)
    }

    get("/json/gson") {
        call.respond(mapOf("hello" to "world"))
    }
}*/
