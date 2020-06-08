package com.xch.demo.fragment.sort.content

import com.chad.library.adapter.base.entity.SectionEntity

class SectionBean constructor(private var sectionContentItemEntity: SectionContentItemEntity?): SectionEntity {

    var id = 0
    constructor(header: String):this(null){
        id = -1
    }

    override val isHeader: Boolean
        get()  {
            return sectionContentItemEntity==null
        }
}