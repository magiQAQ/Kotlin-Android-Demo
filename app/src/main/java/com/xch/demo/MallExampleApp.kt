package com.xch.demo

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.joanzapata.iconify.fonts.FontAwesomeModule
import com.xch.lib.global.Mall

@Suppress("unused")
class MallExampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Mall.init(this)
            .withLoaderDelayed(0)
            //之后使用远程部署的服务器
            .withApiHost("http://mock.fulingjie.com/mock/api/")
            .withIcon(FontAwesomeModule())
            .configure()
    }
}