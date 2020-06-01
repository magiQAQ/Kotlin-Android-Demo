package com.xch.lib.net

import com.xch.lib.global.GlobalKeys
import com.xch.lib.global.Mall
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 创建Retrofit的各个实例
 */
object RestCreator {
    /**
     * 构建我们的okHttp
     */
    private object OkHttpHolder {
        private const val TIME_OUT = 2L
        private val BUILDER = OkHttpClient.Builder()
        internal val OK_HTTP_CLIENT = BUILDER
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()
    }


    private object RetrofitHolder {
        //http://demo.com/
        //从全局的配置中取出baseUrl
        private val BASE_URL = Mall.getConfiguration<String>(GlobalKeys.API_HOST)
        internal val RETROFIT_CLIENT = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpHolder.OK_HTTP_CLIENT)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    private object RestServiceHolder {
        internal val REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT.create(RestService::class.java)
    }

    val restService: RestService
        get() = RestServiceHolder.REST_SERVICE


}