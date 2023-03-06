package uz.gita.domain.use_case.auth.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.core.utils.ResultData
import uz.gita.domain.modul.auth.request.SignUpVerifyRequestModel
import uz.gita.domain.modul.auth.response.VerifySignUpResponseModel

import uz.gita.domain.repository.AuthRepository

import uz.gita.domain.use_case.auth.SignUpVerifyUseCase

import java.net.ConnectException

import javax.inject.Inject

internal class SignUpVerifyUseCaseImpl(
    private val authRepository: AuthRepository,
) : SignUpVerifyUseCase {

    override fun signUpVerify(signUpVerifyRequest: SignUpVerifyRequestModel): Flow<ResultData<VerifySignUpResponseModel>> =
        flow {
            val response = authRepository.verifySignUp(signUpVerifyRequest)
            when (response) {
                is ResultData.Error -> {
                    emit(ResultData.Error(response.error))
                }
                is ResultData.Message -> {
                    emit(ResultData.Message(response.message))
                }
                is ResultData.Success -> {

                    emit(ResultData.Success(response.data))
                }
            }
        }.catch() {
            if (it is ConnectException) {
                emit(ResultData.Message("Internet mavjut emas"))
            }


        }.flowOn(Dispatchers.IO)
}