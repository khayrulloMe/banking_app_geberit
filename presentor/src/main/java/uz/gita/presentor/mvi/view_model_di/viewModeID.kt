package uz.gita.presentor.mvi.view_model_di


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module
import uz.gita.domain.use_case_di.useCaseModule
import uz.gita.presentor.mvi.sign_in.vm.SignInViewModel
import uz.gita.presentor.mvi.sign_in.vm.impl.SignInViewModelImp

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
val viewModuleDI = module {
    viewModelOf(::SignInViewModelImp) { bind<SignInViewModel>() }
}