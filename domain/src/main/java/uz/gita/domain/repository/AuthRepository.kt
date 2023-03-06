package uz.gita.domain.repository

import uz.gita.core.utils.ResultData
import uz.gita.domain.modul.auth.request.*
import uz.gita.domain.modul.auth.response.*


/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
interface AuthRepository {
    suspend fun signUp(signUpRequest: SignUpRequestModel): ResultData<SignUpResponseModel>
    suspend fun signIn(signInRequest: SignInRequestModel): ResultData<SignInResponseModel>
    suspend fun verifySignIn(signInVerifyRequest: SignInVerifyRequestModel): ResultData<VerifySignInResponseModel>
    suspend fun verifySignUp(signUpVerifyRequest: SignUpVerifyRequestModel): ResultData<VerifySignUpResponseModel>

}