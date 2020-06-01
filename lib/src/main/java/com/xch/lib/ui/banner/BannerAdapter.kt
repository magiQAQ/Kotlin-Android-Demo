package com.xch.lib.ui.banner

import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.youth.banner.adapter.BannerAdapter


class ImageAdapter(private var context: Context, urls: List<String>) : BannerAdapter<String, ImageAdapter.BannerViewHolder>(urls) {

    private val bannerOptions = RequestOptions()
        //全部缓存图片
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .dontAnimate()
        .centerCrop()

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val imageView = AppCompatImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder, url: String, position: Int, size: Int) {
        Glide.with(context)
            .load(url)
            .apply(bannerOptions)
            .into(holder.imageView)
    }

    class BannerViewHolder(view: AppCompatImageView) : RecyclerView.ViewHolder(view) {
        var imageView: AppCompatImageView = view
    }
}