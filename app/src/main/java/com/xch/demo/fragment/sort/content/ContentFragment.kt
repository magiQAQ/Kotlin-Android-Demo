package com.xch.demo.fragment.sort.content

import android.os.Bundle
import android.view.View
import com.xch.demo.R
import com.xch.lib.fragments.MallFragment

class ContentFragment:MallFragment(){

    companion object{
        private val argsContentId = "CONTENT_ID"

        fun newInstance(contentId: Int): ContentFragment{
            val args = Bundle()
            args.putInt(argsContentId,contentId)
            val fragment = ContentFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun setLayout(): Any {
        return R.layout.fragment_list_content
    }

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {
        TODO("Not yet implemented")
    }
}