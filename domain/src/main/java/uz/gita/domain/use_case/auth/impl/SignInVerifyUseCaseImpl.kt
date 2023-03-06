package uz.gita.domain.use_case.auth.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.core.utils.ResultData
import uz.gita.domain.modul.auth.request.SignInVerifyRequestModel
import uz.gita.domain.modul.auth.response.VerifySignInResponseModel
import uz.gita.domain.repository.AuthRepository
import uz.gita.domain.use_case.auth.SignInVerifyUseCase
import java.net.ConnectException


internal class SignInVerifyUseCaseImpl(
    private val authRepository: AuthRepository,
) : SignInVerifyUseCase {
    override fun signInVerify(signInVerifyRequest: SignInVerifyRequestModel): Flow<ResultData<VerifySignInResponseModel>> =
        flow {
            val response = authRepository.verifySignIn(signInVerifyRequest)
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
