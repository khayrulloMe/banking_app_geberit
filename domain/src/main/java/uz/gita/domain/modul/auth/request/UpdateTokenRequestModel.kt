package uz.gita.domain.modul.auth.request

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateTokenRequestModel(
    @SerializedName("refresh-token")
    val refreshToken: String
)
