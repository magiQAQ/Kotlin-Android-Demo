package com.xch.lib.global

import android.app.Application
import android.content.Context
import com.blankj.utilcode.util.Utils
import com.xch.lib.util.storage.MemoryStore

object Mall {
    val configurator:Configurator
        get() = Configurator.instance

    fun init(context:Context) : Configurator{
        MemoryStore.instance.addData(GlobalKeys.APPLICATION_CONTEXT,context.applicationContext)
        Utils.init(context as Application)
        return Configurator.instance
    }

    fun <T> getConfiguration(key:Enum<GlobalKeys>):T{
        return configurator.getConfiguration(key)
    }
}