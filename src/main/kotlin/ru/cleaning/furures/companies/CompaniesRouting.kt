package ru.cleaning.furures.companies

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureCompaniesRouting() {
    routing {
        get("/companies") {
            val companyController = CompaniesController(call = call)
            val items = companyController.getCompanies().map { item ->
                CompanyModel(title = item.title, address = item.address)
            }
            call.respond(CompaniesResponseRemote(items))
        }

        post("/companies") {
            val companyController = CompaniesController(call = call)
            companyController.addNewCompany()
        }
    }
}