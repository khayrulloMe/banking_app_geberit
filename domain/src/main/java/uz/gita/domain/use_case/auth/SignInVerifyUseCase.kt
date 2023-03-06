package uz.gita.domain.use_case.auth

import kotlinx.coroutines.flow.Flow
import uz.gita.core.utils.ResultData
import uz.gita.domain.modul.auth.request.SignInVerifyRequestModel
import uz.gita.domain.modul.auth.response.VerifySignInResponseModel


/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
interface SignInVerifyUseCase {
    fun signInVerify(signInVerifyRequest: SignInVerifyRequestModel): Flow<ResultData<VerifySignInResponseModel>>
}