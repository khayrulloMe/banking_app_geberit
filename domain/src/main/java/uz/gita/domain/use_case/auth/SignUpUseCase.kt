package uz.gita.domain.use_case.auth

import kotlinx.coroutines.flow.Flow
import uz.gita.core.utils.ResultData
import uz.gita.domain.modul.auth.request.SignUpRequestModel
import uz.gita.domain.modul.auth.response.SignUpResponseModel


/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
interface SignUpUseCase {
    fun signUp(signUpRequest: SignUpRequestModel): Flow<ResultData<SignUpResponseModel>>

}