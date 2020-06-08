package com.xch.demo.fragment

import android.graphics.Color
import com.xch.demo.fragment.index.IndexFragment
import com.xch.demo.fragment.sort.SortFragment
import com.xch.lib.fragments.bottom.BaseBottomFragment
import com.xch.lib.fragments.bottom.BottomItemFragment
import com.xch.lib.fragments.bottom.BottomTabBean
import com.xch.lib.fragments.bottom.ItemBuilder

class MallMainFragment : BaseBottomFragment() {
    override fun setItems(builder: ItemBuilder): LinkedHashMap<BottomTabBean, BottomItemFragment> {
        val items = LinkedHashMap<BottomTabBean,BottomItemFragment>()
        //添加需要的主界面和tab对,需要几个添加几个
        //框架会自动的判断并渲染出正确的主界面
        //不需要调整任何代码
        items[BottomTabBean("{fa-home}","首页")] = IndexFragment()
        items[BottomTabBean("{fa-sort}","分类")] = SortFragment()
        items[BottomTabBean("{fa-shopping-cart}","购物车")] = IndexFragment()
        items[BottomTabBean("{fa-user}","我的")] = IndexFragment()
        return builder.addItems(items).build()
    }

    override fun setIndexFragment(): Int {
        return 0
    }

    override fun setClickedColor(): Int {
        return Color.parseColor("#ffff8800")
    }
}