package uz.gita.data.di

import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.androidx.workmanager.BuildConfig
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.data.local.LocalStorage
import uz.gita.data.remote.api_service.AuthApi
import uz.gita.data.utils.insertTokenInterceptor
import uz.gita.data.utils.refreshTokenInterceptor
import uz.gita.domain.repository.AuthRepository
import uz.gita.data.repository.AuthRepositoryImpl

/*CREATED BY
MATKARIMOV KHAYRULLO 
IN ()
*/
val apiModel = module {
    single<Gson> {
        Gson()
    }
    single {
        LocalStorage(context = get())
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(insertTokenInterceptor(preference = get()))
            .addInterceptor(refreshTokenInterceptor(preference = get()))
            .build()
    }

    single {
        Retrofit
            .Builder()
//            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(AuthApi::class.java)

    }


}

val repositoryModel = module {
    singleOf(::AuthRepositoryImpl) { bind<AuthRepository>() }
}