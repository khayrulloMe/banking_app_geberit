package uz.gita.data.remote.api_service

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.data.remote.dto.auth.request.*

import uz.gita.data.remote.dto.auth.response.*


interface AuthApi {

    @POST("auth/sign-up")
    suspend fun signUpUser(@Body signUpUserRequest: SignUpRequest): Response<SignUpResponse>

    @POST("auth/sign-up/verify")
    suspend fun verifySignUpUser(@Body verifyRequest: SignUpVerifyRequest): Response<VerifySignUpResponse>

    @POST("auth/sign-in")
    suspend fun signInUser(@Body signInRequest: SignInRequest): Response<SignInResponse>

    @POST("auth/sign-in/verify")
    suspend fun verifySignInUser(@Body verifyRequest: SignInVerifyRequest): Response<VerifySignInResponse>

    @POST("auth/update-token")
    suspend fun updateToken(@Body updateTokenRequest: UpdateTokenRequest): Response<UpdateTokenResponse>


}