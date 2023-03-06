package uz.gita.data.remote.dto.auth.request


import kotlinx.serialization.Serializable

@Serializable
data class SignInVerifyRequest(
    val code: String,
    val token: String
)