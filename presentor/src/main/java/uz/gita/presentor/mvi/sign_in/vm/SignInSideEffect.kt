package uz.gita.presentor.mvi.sign_in.vm

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/

sealed interface SignInSideEffect {
    data class Message(val message: String) : SignInSideEffect

}