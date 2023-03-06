package uz.gita.domain.use_case.auth.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.core.utils.ResultData
import uz.gita.domain.modul.auth.request.SignUpRequestModel
import uz.gita.domain.modul.auth.response.SignUpResponseModel
import uz.gita.domain.repository.AuthRepository
import uz.gita.domain.use_case.auth.SignUpUseCase

import java.net.ConnectException

import javax.inject.Inject

internal class SignUpUseCaseImpl(
    private val authRepository: AuthRepository
) : SignUpUseCase {
    override fun signUp(signUpRequest: SignUpRequestModel): Flow<ResultData<SignUpResponseModel>> = flow {
        val response = authRepository.signUp(signUpRequest)
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