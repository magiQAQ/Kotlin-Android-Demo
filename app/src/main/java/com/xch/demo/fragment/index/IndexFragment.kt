package com.xch.demo.fragment.index

import android.os.Bundle
import android.view.View
import com.xch.demo.R
import com.xch.lib.fragments.bottom.BottomItemFragment
import kotlinx.android.synthetic.main.fragment_index.*

class IndexFragment : BottomItemFragment(){
    override fun setLayout(): Any {
        return R.layout.fragment_index
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {

    }
}