package com.xch.demo.fragment.index

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.xch.demo.R
import com.xch.lib.fragments.bottom.BottomItemFragment
import kotlinx.android.synthetic.main.fragment_index.*

class IndexFragment : BottomItemFragment(){
    override fun setLayout(): Any {
        return R.layout.fragment_index
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {

    }

    //惰性的加载数据和UI
    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        val manager = GridLayoutManager(context,4)
        rv_index.layoutManager = manager
        rv_index.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }
}