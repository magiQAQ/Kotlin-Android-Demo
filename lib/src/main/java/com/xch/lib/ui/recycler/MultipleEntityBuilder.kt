package com.xch.lib.ui.recycler

class MultipleEntityBuilder {
    companion object {
        private val FIELD = LinkedHashMap<Any, Any>()
    }

    init {
        //先清除上一次数据
        FIELD.clear()
    }

    fun setItemType(itemType: Int): MultipleEntityBuilder {
        FIELD[MultipleFields.ITEM_TYPE] = itemType
        return this
    }

    fun setField(key: Any, value: Any?): MultipleEntityBuilder {
        FIELD[key] = value?:return this
        return this
    }

    fun setFields(map: LinkedHashMap<*,*>): MultipleEntityBuilder {
        FIELD.putAll(map)
        return this
    }

    fun build(): MultipleItemEntity{
        return MultipleItemEntity(FIELD)
    }


}