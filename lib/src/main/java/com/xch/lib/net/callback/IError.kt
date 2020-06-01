package com.xch.lib.net.callback

interface IError {
    fun onError(code: Int,msg: String)
}