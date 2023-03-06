package uz.gita.domain.modul.auth.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class ErrorResponseBodyModel(
    val message: String
)