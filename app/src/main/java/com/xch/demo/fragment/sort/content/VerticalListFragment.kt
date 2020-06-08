package com.xch.demo.fragment.sort.content

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.xch.demo.R
import com.xch.lib.fragments.MallFragment
import com.xch.lib.net.RestClient
import com.xch.lib.net.callback.ISuccess
import kotlinx.android.synthetic.main.fragment_vertical_list.*

class VerticalListFragment: MallFragment() {

    override fun setLayout(): Any {
        return R.layout.fragment_vertical_list
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {
        val manager = LinearLayoutManager(context)
        rv_vertical_menu_list.layoutManager = manager
        rv_vertical_menu_list.itemAnimator = null
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        RestClient.builder()
            .url("sort_list.php")
            .loader(requireContext())
            .success(object : ISuccess{
                override fun onSuccess(response: String) {
                    TODO("Not yet implemented")
                }
            })
    }


}