package uz.gita.domain.use_case_di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import uz.gita.domain.repository.AuthRepository
import uz.gita.domain.use_case.auth.SignInUseCase
import uz.gita.domain.use_case.auth.SignInVerifyUseCase
import uz.gita.domain.use_case.auth.SignUpUseCase
import uz.gita.domain.use_case.auth.SignUpVerifyUseCase
import uz.gita.domain.use_case.auth.impl.SignInUseCaseImpl
import uz.gita.domain.use_case.auth.impl.SignInVerifyUseCaseImpl
import uz.gita.domain.use_case.auth.impl.SignUpVerifyUseCaseImpl
import uz.gita.domain.use_case.auth.impl.SignUpUseCaseImpl

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/

val useCaseModule = module {
    factoryOf(::SignInUseCaseImpl) { bind<SignInUseCase>() }
    factoryOf(::SignUpUseCaseImpl) { bind<SignUpUseCase>() }
    factoryOf(::SignInVerifyUseCaseImpl) { bind<SignInVerifyUseCase>() }
    factoryOf(::SignUpVerifyUseCaseImpl) { bind<SignUpVerifyUseCase>() }


}
