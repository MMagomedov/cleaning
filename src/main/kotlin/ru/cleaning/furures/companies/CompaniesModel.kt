package ru.cleaning.furures.companies

import kotlinx.serialization.Serializable

@Serializable
class CompaniesModel(
    val id: Int,
    val title: String,
    val rating: Float,
    val ratingCount: Int,
    val address: String
)