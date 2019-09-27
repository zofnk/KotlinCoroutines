package com.demo.dokong.kotlincoroutinestest.response

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 11:37
 */
object RetrofitClient {

    private const val time = 5L

    val request: RequestService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(RequestUrl.BASE_URL)
            .client(okhttpManager.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return@lazy retrofit.create(RequestService::class.java)
    }

    private val okhttpManager by lazy {
        OkHttpClient().newBuilder()
            .apply {
                connectTimeout(time, TimeUnit.SECONDS)
                readTimeout(time, TimeUnit.SECONDS)
                writeTimeout(time, TimeUnit.SECONDS)

                addInterceptor(HttpLoggingInterceptor("DOKONG").apply {
                    setPrintLevel(HttpLoggingInterceptor.Level.BODY)
                    setColorLevel(Level.INFO)
                })
            }
    }
}