package ru.cleaning.furures.companies

import kotlinx.serialization.Serializable

@Serializable
data class CompaniesReceiveRemote(
    val title: String, val address: String
)

@Serializable
data class CompaniesResponseRemote(
    val companies: List<CompanyModel>
)

@Serializable
data class CompanyModel(
    val title: String, val address: String
)