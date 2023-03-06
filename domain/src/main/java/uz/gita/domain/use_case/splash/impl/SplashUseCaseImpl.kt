package uz.gita.domain.use_case.splash.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


import uz.gita.domain.use_case.splash.SplashUseCase
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor(
) : SplashUseCase {
    override fun isLogIn(): Flow<Boolean> = flow {
        emit(false)
    }
}