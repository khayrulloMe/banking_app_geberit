package uz.gita.banking_app_geberit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.gita.banking_app_geberit.ui.theme.AppTheme
import uz.gita.presentor.mvi.sign_in.vm.SignInViewModel
import uz.gita.presentor.mvi.sign_in.vm.impl.SignInViewModelImp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {

            }
        }
    }
}
