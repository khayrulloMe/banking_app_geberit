package uz.gita.domain.use_case.auth

import kotlinx.coroutines.flow.Flow
import uz.gita.core.utils.ResultData
import uz.gita.domain.modul.auth.request.SignUpVerifyRequestModel
import uz.gita.domain.modul.auth.response.VerifySignUpResponseModel


/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
interface SignUpVerifyUseCase {
    fun signUpVerify(signUpVerifyRequest: SignUpVerifyRequestModel): Flow<ResultData<VerifySignUpResponseModel>>
}