package uz.gita.domain.use_case.auth

import kotlinx.coroutines.flow.Flow
import uz.gita.core.utils.ResultData
import uz.gita.domain.modul.auth.request.SignInRequestModel
import uz.gita.domain.modul.auth.response.SignInResponseModel


/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
interface SignInUseCase {
    fun signIn(signInRequest: SignInRequestModel): Flow<ResultData<SignInResponseModel>>

}