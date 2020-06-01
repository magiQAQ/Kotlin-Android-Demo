package com.xch.demo.fragment

import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.ToastUtils
import com.xch.demo.R
import com.xch.lib.fragments.MallFragment

class TestFragment: MallFragment() {
    override fun setLayout(): Any {
        return R.layout.fragment_test
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {
        ToastUtils.showShort("初始化完成")
    }
}