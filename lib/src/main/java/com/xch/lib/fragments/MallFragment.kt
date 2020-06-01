package com.xch.lib.fragments

import android.widget.Toast
import com.blankj.utilcode.util.ToastUtils

abstract class MallFragment :BaseFragment(){

    private var mTouchTime :Long = 0L

    companion object {
        private const val WAIT_TIME = 2000L
    }

    protected fun exitWithDoubleClick(): Boolean{
        if (System.currentTimeMillis() - mTouchTime < WAIT_TIME) {
            _mActivity.finish()
        } else {
            mTouchTime = System.currentTimeMillis()
            ToastUtils.showShort("双击退出")
        }
        return true
    }

    //关于文件或者Camera权限的内容

}