package com.xch.lib.ui.recycler

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.GridLayoutManager
import com.blankj.utilcode.util.AdaptScreenUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.GridSpanSizeLookup
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.xch.lib.R
import com.xch.lib.ui.banner.ImageAdapter
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator

class MultipleRecyclerViewAdapter constructor(data: MutableList<MultipleItemEntity>) :
    BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder>(data),
    GridSpanSizeLookup,
    OnItemClickListener {

    //因为每次加载RecyclerView都会初始化变量(Banner实例)
    //确保初始化一次
    private var isInitBanner = false

    //初始化静态的参数和对象
    companion object {
        private val RECYCLER_OPTIONS = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()

        fun create(data: MutableList<MultipleItemEntity>): MultipleRecyclerViewAdapter {
            return MultipleRecyclerViewAdapter(data)
        }
    }

    init {
        initView()
    }

    private fun initView() {
        addItemType(ItemType.TEXT, R.layout.item_multiple_text)
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image)
        addItemType(ItemType.TEXT_IMAGE, R.layout.item_multiple_image_text)
        addItemType(ItemType.BANNER, R.layout.item_multiple_banner)
    }

    override fun createBaseViewHolder(view: View): MultipleViewHolder {
        return MultipleViewHolder.create(view)
    }

    //将数据转化成UI需要的方法
    override fun convert(holder: MultipleViewHolder, entity: MultipleItemEntity) {
        val text: String
        val imageUrl: String
        val bannerImages: ArrayList<String>
        when (holder.itemViewType) {
            ItemType.TEXT -> {
                text = entity.getFields(MultipleFields.TEXT)
                holder.setText(R.id.text_single, text)
            }
            ItemType.IMAGE -> {
                imageUrl = entity.getFields(MultipleFields.IMAGE_URL)
                Glide.with(context)
                    .load(imageUrl)
                    .apply(RECYCLER_OPTIONS)
                    .into(holder.getView(R.id.image_single) as AppCompatImageView)
            }
            ItemType.TEXT_IMAGE -> {
                text = entity.getFields(MultipleFields.TEXT)
                imageUrl = entity.getFields(MultipleFields.IMAGE_URL)
                holder.setText(R.id.text_multiple, text)
                Glide.with(context)
                    .load(imageUrl)
                    .apply(RECYCLER_OPTIONS)
                    .into(holder.getView<AppCompatImageView>(R.id.image_multiple))
            }
            ItemType.BANNER -> if (!isInitBanner) {
                bannerImages = entity.getFields(MultipleFields.BANNERS)
                val banner = holder.getView<Banner<String, ImageAdapter>>(R.id.banner_recycler_item)
                banner.setAdapter(ImageAdapter(context, bannerImages))
                    .setBannerRound(AdaptScreenUtils.pt2Px(5f).toFloat()).indicator =
                    CircleIndicator(context)
                isInitBanner = true
            }
            else -> {
            }
        }
    }

    //根据SpanSize来判断多布局的分割
    override fun getSpanSize(
        gridLayoutManager: GridLayoutManager,
        viewType: Int,
        position: Int
    ): Int {
        return data[position].getFields(MultipleFields.SPAN_SIZE)
    }

    //轮播图的点击事件
    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        TODO("Not yet implemented")
    }
}