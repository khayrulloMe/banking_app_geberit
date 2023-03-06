package uz.gita.domain.use_case.splash

import kotlinx.coroutines.flow.Flow

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
interface SplashUseCase {
    fun isLogIn(): Flow<Boolean>
}