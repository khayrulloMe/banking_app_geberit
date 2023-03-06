package uz.gita.domain.modul.auth.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpVerifyRequestModel(
    val code: String,
    val token: String
)