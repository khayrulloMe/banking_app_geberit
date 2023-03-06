package uz.gita.data.mappers

import uz.gita.data.remote.dto.auth.response.SignInResponse
import uz.gita.data.remote.dto.auth.response.SignUpResponse
import uz.gita.data.remote.dto.auth.response.VerifySignInResponse
import uz.gita.data.remote.dto.auth.response.VerifySignUpResponse
import uz.gita.domain.modul.auth.request.*
import uz.gita.domain.modul.auth.response.*

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/


fun SignInResponse.toModel(): SignInResponseModel = SignInResponseModel(token = this.token)
fun VerifySignInResponse.toModel(): VerifySignInResponseModel =
    VerifySignInResponseModel(accessToken = this.accessToken, refreshToken = this.refreshToken)

fun SignUpResponse.toModel(): SignUpResponseModel = SignUpResponseModel(token = this.token)
fun VerifySignUpResponse.toModel(): VerifySignUpResponseModel =
    VerifySignUpResponseModel(accessToken = this.accessToken, refreshToken = this.refreshToken)

fun SignUpResponseModel.fromModel(): SignUpResponse = SignUpResponse(token = this.token)
fun SignInResponseModel.fromModel(): SignInResponse = SignInResponse(token = this.token)
fun VerifySignInResponseModel.fromModel(): VerifySignInResponse =
    VerifySignInResponse(accessToken = this.accessToken, refreshToken = this.refreshToken)

fun VerifySignUpResponseModel.fromModel(): VerifySignUpResponse =
    VerifySignUpResponse(accessToken = this.accessToken, refreshToken = this.refreshToken)


