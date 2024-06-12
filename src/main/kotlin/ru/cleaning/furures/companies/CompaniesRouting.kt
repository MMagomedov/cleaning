package ru.cleaning.furures.companies

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureCompaniesRouting() {
    routing {
        get("/companies") {

            val companies = arrayListOf<CompaniesModel>()
            companies.add(
                CompaniesModel(
                    1, "Vesna", 4.3f, 23, "Улица Нахимова, 5, Махачкала"
                )
            )
            companies.add(
                CompaniesModel(
                    2, "Glyanets", 4.5f, 40, "Улица Салаватова, 43, Махачкала"
                )
            )

            companies.add(
                CompaniesModel(
                    3, "Снежинка", 4.2f, 4, "6-й Майский тупик, 2, Махачкала"
                )
            )

            call.respond(CompaniesResponseRemote(companies = companies))
        }
    }
}