package com.xch.lib.ui.recycler

import android.content.ClipData
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.GridSpanSizeLookup
import com.chad.library.adapter.base.listener.OnItemClickListener

class MultipleRecyclerViewAdapter constructor(data: MutableList<MultipleItemEntity>) :
    BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder>(data),
    GridSpanSizeLookup,
    OnItemClickListener{

    //初始化静态的参数和对象
    companion object {
        private val RECYCLER_OPTIONS = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()

        fun create(data: MutableList<MultipleItemEntity>):MultipleRecyclerViewAdapter{
            return MultipleRecyclerViewAdapter(data)
        }
    }

    init {

    }

    private fun initView(){
        addItemType(ItemType.TEXT, TODO())
        addItemType(ItemType.IMAGE, TODO())
        addItemType(ItemType.TEXT_IMAGE, TODO())
        addItemType(ItemType.BANNER, TODO())
    }

    //将数据转化成UI需要的方法
    override fun convert(holder: MultipleViewHolder, item: MultipleItemEntity) {
        TODO("Not yet implemented")
    }

    //根据SpanSize来判断多布局的分割
    override fun getSpanSize(gridLayoutManager: GridLayoutManager, viewType: Int, position: Int): Int{
        TODO("adadadad")
    }

    //轮播图的点击事件
    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        TODO("Not yet implemented")
    }
}