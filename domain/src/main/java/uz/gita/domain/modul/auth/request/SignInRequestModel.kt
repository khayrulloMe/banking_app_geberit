package uz.gita.domain.modul.auth.request

import kotlinx.serialization.Serializable


@Serializable
data class SignInRequestModel(
    val password: String,
    val phone: String
)