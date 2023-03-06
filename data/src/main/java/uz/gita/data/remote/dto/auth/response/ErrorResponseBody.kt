package uz.gita.data.remote.dto.auth.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class ErrorResponseBody(
    val message: String
)