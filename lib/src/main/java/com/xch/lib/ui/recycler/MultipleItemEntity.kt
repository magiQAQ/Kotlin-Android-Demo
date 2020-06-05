package com.xch.lib.ui.recycler

import com.chad.library.adapter.base.entity.MultiItemEntity

class MultipleItemEntity internal constructor(fields: LinkedHashMap<Any, Any>) : MultiItemEntity{

    private val multipleFields = LinkedHashMap<Any, Any>()

    init {
        multipleFields.putAll(fields)
    }

    companion object {
        fun builder():MultipleEntityBuilder {
            return MultipleEntityBuilder()
        }
    }

    override val itemType: Int
        get() = multipleFields[MultipleFields.ITEM_TYPE] as Int

    @Suppress("UNCHECKED_CAST")
    fun <T> getFields(key: Any):T {
        return multipleFields[key] as T
    }

    fun setField(key: Any, value: Any):MultipleItemEntity {
        multipleFields[key] = value
        return this
    }
}
