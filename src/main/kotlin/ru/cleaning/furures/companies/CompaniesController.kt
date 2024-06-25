package ru.cleaning.furures.companies

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.cleaning.database.companies.Companies
import ru.cleaning.database.companies.CompanyDTO

class CompaniesController(private val call: ApplicationCall) {

    suspend fun addNewCompany() {
        val receive = call.receive<CompaniesReceiveRemote>()
        if (receive.title.isBlank()) {
            call.respond(HttpStatusCode.BadRequest, "Title cannot be empty")
        }
        if (receive.address.isBlank()) {
            call.respond(HttpStatusCode.BadRequest, "Address cannot be empty")
        }
        Companies.insert(
            CompanyDTO(
                title = receive.title, address = receive.address
            )
        )
        call.respond(HttpStatusCode.OK, "Company added")
    }

    fun getCompanies(): List<CompanyDTO> {
        val companies = Companies.fetchCompanies()
        return companies
    }
}