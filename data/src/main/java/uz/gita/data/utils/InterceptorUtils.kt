package uz.gita.data.utils

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import uz.gita.data.local.LocalStorage
import uz.gita.domain.modul.auth.response.UpdateTokenResponseModel

/*CREATED BY
MATKARIMOV KHAYRULLO
IN ()
*/

fun insertTokenInterceptor(
    preference: LocalStorage
) = Interceptor { chain ->
    val request = chain.request().newBuilder()
        .addHeader("authorization", "Bearer ${preference.accessToken}").build()
    chain.proceed(request)
}

fun refreshTokenInterceptor(
    preference: LocalStorage
) = Interceptor { chain ->
    val request = chain.request()
    val response = chain.proceed(request)
    if (response.code() == 401) {
        response.close()

        val data = JSONObject()
        data.put("refresh-token", preference.refreshToken)
        val body =
            RequestBody.create(MediaType.get("application/json; charset=utf-8"), data.toString())

        val requestRefresh = request.newBuilder()
            .method("POST", body)
            .url("${Const.BASE_URL}auth/update-token")
            .build()

        val responseRefresh = chain.proceed(requestRefresh)
        if (responseRefresh.code() == 401) {
            return@Interceptor responseRefresh

            // refresh token ham eskirdi login screen navigate
        }

        if (responseRefresh.code() == 200) {
            responseRefresh.body()?.let {
                val refreshData = Gson().fromJson(it.string(), UpdateTokenResponseModel::class.java)
                preference.refreshToken = refreshData.refreshToken
                preference.accessToken = refreshData.accessToken
            }

            responseRefresh.close()

            val requestSecond = request.newBuilder()
                .removeHeader("token")
                .addHeader("token", preference.accessToken)
                .build()
            return@Interceptor chain.proceed(requestSecond)
        }
    }

    return@Interceptor response
}