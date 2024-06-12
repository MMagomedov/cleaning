package ru.cleaning

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database
import ru.cleaning.furures.companies.configureCompaniesRouting
import ru.cleaning.furures.login.configureLoginRouting
import ru.cleaning.furures.register.configureRegisterRouting
import ru.cleaning.plugins.*

fun main() {
    Database.connect(
        "jdbc:postgresql://localhost:5432/cleaning",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "123"
    )


    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

fun Application.module() {
//    configureSockets()
    configureLoginRouting()
    configureRegisterRouting()
    configureCompaniesRouting()
    configureSerialization()
    configureRouting()
}
