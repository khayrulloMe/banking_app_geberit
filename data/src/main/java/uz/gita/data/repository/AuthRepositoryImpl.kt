package uz.gita.data.repository


import android.util.Log
import com.google.gson.Gson
import uz.gita.core.utils.ResultData
import uz.gita.data.mappers.fromModel
import uz.gita.data.mappers.toModel
import uz.gita.data.remote.api_service.AuthApi
import uz.gita.data.remote.dto.auth.response.ErrorResponseBody
import uz.gita.domain.modul.auth.request.*
import uz.gita.domain.modul.auth.response.*
import uz.gita.domain.repository.AuthRepository


internal class AuthRepositoryImpl(private val authApi: AuthApi, private val gson: Gson) :
    AuthRepository {
    override suspend fun signUp(signUpRequest: SignUpRequestModel): ResultData<SignUpResponseModel> {

        val result = authApi.signUpUser(signUpRequest.fromModel())
        if (result.isSuccessful) {
            result.body()?.let {
                return ResultData.Success(it.toModel())
            }
        } else {
            result.errorBody()?.apply {
                val errorResponse = gson.fromJson(this.string(), ErrorResponseBody::class.java)
                return ResultData.Message(errorResponse.message)
            }
        }
        return ResultData.Error(Exception("not found Exception"))

    }

    override suspend fun signIn(signInRequestModel: SignInRequestModel): ResultData<SignInResponseModel> {
        val result = authApi.signInUser(signInRequestModel.fromModel())
        if (result.isSuccessful) {
            result.body()?.let {
                return ResultData.Success(it.toModel())
            }
        } else {
            result.errorBody()?.apply {
                val errorResponse = gson.fromJson(this.string(), ErrorResponseBody::class.java)
                return ResultData.Message(errorResponse.message)
            }
        }
        return ResultData.Error(Exception("not found Exception"))

    }

    override suspend fun verifySignIn(signInVerifyRequest: SignInVerifyRequestModel): ResultData<VerifySignInResponseModel> {
        val result = authApi.verifySignInUser(verifyRequest = signInVerifyRequest.fromModel())
        if (result.isSuccessful) {
            result.body()?.let {

                return ResultData.Success(it.toModel())
            }
        } else {
            result.errorBody()?.apply {
                val errorResponse = gson.fromJson(this.string(), ErrorResponseBody::class.java)
                return ResultData.Message(errorResponse.message)
            }
        }
        return ResultData.Error(Exception("not found Exception"))

    }

    override suspend fun verifySignUp(signUpVerifyRequest: SignUpVerifyRequestModel): ResultData<VerifySignUpResponseModel> {
        val result = authApi.verifySignUpUser(signUpVerifyRequest.fromModel())
        if (result.isSuccessful) {
            result.body()?.let {
                return ResultData.Success(it.toModel())
            }
        } else {
            result.errorBody()?.apply {
                val errorResponse = gson.fromJson(this.string(), ErrorResponseBody::class.java)
                return ResultData.Message(errorResponse.message)
            }
        }
        return ResultData.Error(Exception("not found Exception"))

    }

}