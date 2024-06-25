package ru.cleaning.database.companies

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Companies : Table("companies") {
    private val title = Companies.varchar("title", 50)
    private val address = Companies.varchar("address", 250)


    fun insert(companyDTO: CompanyDTO) {
        transaction {
            Companies.insert {
                it[title] = companyDTO.title
                it[address] = companyDTO.address
            }
        }
    }

    fun fetchCompanies(): List<CompanyDTO> {
        return try {
            transaction {
                Companies.selectAll().map { data ->
                    CompanyDTO(
                        title = data[title], address = data[address]
                    )
                }.toList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}