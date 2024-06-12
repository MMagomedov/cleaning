package ru.cleaning.furures.companies

import kotlinx.serialization.Serializable

@Serializable
data class CompaniesResponseRemote(
    val companies: List<CompaniesModel>
)