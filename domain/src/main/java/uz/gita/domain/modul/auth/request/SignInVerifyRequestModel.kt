package uz.gita.domain.modul.auth.request


import kotlinx.serialization.Serializable

@Serializable
data class SignInVerifyRequestModel(
    val code: String,
    val token: String
)