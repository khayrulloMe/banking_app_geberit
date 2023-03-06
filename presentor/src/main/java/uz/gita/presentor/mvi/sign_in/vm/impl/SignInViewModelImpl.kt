package uz.gita.presentor.mvi.sign_in.vm.impl

import android.util.Log
import androidx.lifecycle.ViewModel

import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.core.utils.ResultData
import uz.gita.domain.use_case.auth.SignInUseCase
import uz.gita.presentor.mvi.sign_in.vm.SignInIntent
import uz.gita.presentor.mvi.sign_in.vm.SignInSideEffect
import uz.gita.presentor.mvi.sign_in.vm.SignInUiState
import uz.gita.presentor.mvi.sign_in.vm.SignInViewModel
import javax.inject.Inject

class SignInViewModelImp(private val signInUseCase: SignInUseCase) : SignInViewModel, ViewModel() {
    override val container: Container<SignInUiState, SignInSideEffect> =
        container(SignInUiState.Loading(false))

    override fun onEventDispatcher(intent: SignInIntent) = intent {
        when (intent) {
            SignInIntent.OpenSignUp -> {

            }

            is SignInIntent.SignIn -> {

                reduce {
                    SignInUiState.Loading(true)
                }
                signInUseCase.signIn(intent.signInRequest).collect {

                    reduce {
                        SignInUiState.Loading(false)
                    }
                    when (it) {
                        is ResultData.Error -> {
                            it.error.message?.let {
                                postSideEffect(SignInSideEffect.Message(it))
                            }
                        }
                        is ResultData.Message -> {
                            postSideEffect(SignInSideEffect.Message(it.message))
                        }
                        is ResultData.Success -> {

                        }
                    }
                }
            }
        }

    }

    init {
        Log.d("HHH", "olindi")
    }
}