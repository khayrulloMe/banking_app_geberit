package uz.gita.domain.use_case.auth.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.core.utils.ResultData
import uz.gita.domain.modul.auth.request.SignInRequestModel
import uz.gita.domain.modul.auth.response.SignInResponseModel
import uz.gita.domain.repository.AuthRepository

import uz.gita.domain.use_case.auth.SignInUseCase
import java.net.ConnectException

internal class SignInUseCaseImpl(
    private val authRepository: AuthRepository
) : SignInUseCase {
    override fun signIn(signInRequest: SignInRequestModel): Flow<ResultData<SignInResponseModel>> =
        flow {
            when (val response = authRepository.signIn(signInRequest)) {
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
        }.catch {
            if (it is ConnectException) {
                emit(ResultData.Message("Internet mavjut emas"))
            }


        }.flowOn(Dispatchers.IO)
}