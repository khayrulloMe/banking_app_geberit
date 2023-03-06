package uz.gita.data.remote.dto.auth.request

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateTokenRequest(
    @SerializedName("refresh-token")
    val refreshToken: String
)
