package uz.gita.presentor.mvi.sign_in.vm

import uz.gita.domain.modul.auth.request.SignInRequestModel

sealed interface SignInIntent {
    object OpenSignUp : SignInIntent
    data class SignIn(val signInRequest: SignInRequestModel) : SignInIntent
}