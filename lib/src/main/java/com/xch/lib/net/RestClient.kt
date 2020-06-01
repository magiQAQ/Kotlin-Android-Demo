package com.xch.lib.net

import android.content.Context
import com.xch.lib.net.callback.*
import com.xch.lib.ui.loader.LoaderStyles
import com.xch.lib.ui.loader.MallLoader
import retrofit2.Call
import retrofit2.Callback
import java.util.*

/**
 * 在所有依赖mall-library的app中对外暴露直接使用的客户端
 */
class RestClient internal constructor(
    private val url: String?,
    private val params:WeakHashMap<String,Any>?,
    private val request: IRequest?,
    private val success: ISuccess?,
    private val failure: IFailure?,
    private val error: IError?,
    private val complete: IComplete?,
    private val context: Context?,
    private val loaderStyles: LoaderStyles?
){
    companion object {
        fun builder():RestClientBuilder {
            return RestClientBuilder()
        }
    }

    private fun request(method : HttpMethod){
        val service = RestCreator.restService
        val call: Call<String>?
        request?.onRequestStart()

        if (loaderStyles != null){
            MallLoader.showLoading(context,loaderStyles)
        }

        call = when(method){
            HttpMethod.GET -> service.get(url,params)
            HttpMethod.POST -> service.post(url, params)
            HttpMethod.PUT -> service.put(url, params)
            HttpMethod.DELETE -> service.delete(url,params)
            //以下先不实现
            HttpMethod.UPLOAD -> TODO()
            HttpMethod.DOWNLOAD -> TODO()
        }

        call.enqueue(requestCallback)
    }

    private val requestCallback: Callback<String>
        get() = RequestCallbacks(request, success, failure, error, complete, loaderStyles)

    fun get(){
        request(HttpMethod.GET)
    }

    fun post(){
        request(HttpMethod.POST)
    }

    fun put(){
        request(HttpMethod.PUT)
    }

    fun delete(){
        request(HttpMethod.DELETE)
    }
}