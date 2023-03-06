package uz.gita.presentor.mvi.sign_in.vm

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
sealed interface SignInUiState {
    data class Loading(val isLoading: Boolean) : SignInUiState
}