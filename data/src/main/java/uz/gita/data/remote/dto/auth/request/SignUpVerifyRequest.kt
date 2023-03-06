package uz.gita.data.remote.dto.auth.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpVerifyRequest(
    val code: String,
    val token: String
)