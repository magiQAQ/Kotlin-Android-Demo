package com.xch.lib.fragments.bottom

import com.blankj.utilcode.util.ToastUtils
import com.xch.lib.fragments.MallFragment

abstract class BottomItemFragment : MallFragment() {
    private var mTouchTime :Long = 0L

    companion object {
        private const val WAIT_TIME = 2000L
    }

    override fun onBackPressedSupport(): Boolean {
        if (System.currentTimeMillis() - mTouchTime < WAIT_TIME) {
            _mActivity.finish()
        } else {
            mTouchTime = System.currentTimeMillis()
            ToastUtils.showShort("双击退出")
        }
        return true
    }
}