package uz.gita.data.mappers

import uz.gita.data.remote.dto.auth.request.SignInRequest
import uz.gita.data.remote.dto.auth.request.SignInVerifyRequest
import uz.gita.data.remote.dto.auth.request.SignUpRequest
import uz.gita.data.remote.dto.auth.request.SignUpVerifyRequest
import uz.gita.domain.modul.auth.request.*

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/

fun SignInRequestModel.fromModel(): SignInRequest = SignInRequest(this.password, this.phone)


fun SignInVerifyRequestModel.fromModel(): SignInVerifyRequest =
    SignInVerifyRequest(this.code, this.token)

fun SignUpRequestModel.fromModel(): SignUpRequest =
    SignUpRequest(
        bornDate = this.bornDate,
        gender = this.gender,
        firstName = this.firstName,
        lastName = this.lastName,
        password = this.password,
        phone = this.phone
    )

fun SignUpVerifyRequestModel.fromModel(): SignUpVerifyRequest =
    SignUpVerifyRequest(code = this.code, token = this.token)

fun SignInRequest.toModel(): SignInRequestModel =
    SignInRequestModel(this.password, this.phone)

fun SignInVerifyRequest.toModel(): SignInVerifyRequestModel =
    SignInVerifyRequestModel(this.code, this.token)

fun SignUpRequest.toModel(): SignUpRequestModel =
    SignUpRequestModel(
        bornDate = this.bornDate,
        gender = this.gender,
        firstName = this.firstName,
        lastName = this.lastName,
        password = this.password,
        phone = this.phone
    )

fun SignUpVerifyRequest.toModel(): SignUpVerifyRequestModel =
    SignUpVerifyRequestModel(code = this.code, token = this.token)
