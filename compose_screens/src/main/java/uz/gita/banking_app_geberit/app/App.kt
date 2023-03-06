package uz.gita.banking_app_geberit.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import uz.gita.data.di.apiModel
import uz.gita.data.di.repositoryModel
import uz.gita.domain.repository.AuthRepository
import uz.gita.domain.use_case_di.useCaseModule
import uz.gita.presentor.mvi.view_model_di.viewModuleDI


/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(apiModel, repositoryModel, useCaseModule, viewModuleDI)

        }
    }
}