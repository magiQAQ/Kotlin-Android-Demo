package com.xch.demo

import com.xch.demo.fragment.MallMainFragment
import com.xch.lib.activitys.ProxyActivity
import com.xch.lib.fragments.MallFragment

class MainActivity : ProxyActivity() {

    override fun setRootFragment(): MallFragment {
        return MallMainFragment()
    }

}
