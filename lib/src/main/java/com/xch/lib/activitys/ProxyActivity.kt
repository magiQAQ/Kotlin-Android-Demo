package com.xch.lib.activitys

import android.os.Bundle
import android.widget.FrameLayout
import com.xch.lib.R
import com.xch.lib.fragments.MallFragment
import me.yokeyword.fragmentation.SupportActivity

abstract class ProxyActivity: SupportActivity(){
    abstract fun setRootFragment(): MallFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initContainer(savedInstanceState)
    }

    private fun initContainer(savedInstanceState: Bundle?){
        val container = FrameLayout(this)
        container.id = R.id.fragment_container
        setContentView(container)
        if (savedInstanceState == null){
            loadRootFragment(R.id.fragment_container,setRootFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        System.gc()
        System.runFinalization()
    }

}