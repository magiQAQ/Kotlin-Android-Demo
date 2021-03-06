package com.xch.demo.fragment.index

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.xch.demo.R
import com.xch.lib.fragments.bottom.BottomItemFragment
import com.xch.lib.net.RestClient
import com.xch.lib.net.callback.ISuccess
import com.xch.lib.ui.recycler.MultipleRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_index.*

class IndexFragment : BottomItemFragment(){
    override fun setLayout(): Any {
        return R.layout.fragment_index
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tb_index.background.alpha = 0
    }

    //惰性的加载数据和UI
    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        initRecycler()
        initData()
    }

    private fun initRecycler() {
        val manager = GridLayoutManager(context,4)
        rv_index.layoutManager = manager
        rv_index.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    private fun initData() {
        RestClient.builder()
            .url("index.php")
            .loader(requireContext())
            .success(object : ISuccess{
                override fun onSuccess(response: String) {
                    val adapter = MultipleRecyclerViewAdapter
                        .create(IndexDataConverter().setJsonData(response))
                    rv_index.adapter = adapter
                    Log.i("indexData", response)
                }
            })
            .build()
            .get()
    }
}