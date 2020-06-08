package com.xch.lib.ui.recycler

abstract class DataConverter {
    protected val mEntities = ArrayList<MultipleItemEntity>()

    private lateinit var mJsonData: String

    protected val jsonData:String
        get(){
            if (mJsonData.isEmpty()){
                throw NullPointerException("Data is Null!!!")
            }
            return mJsonData
        }

    abstract fun convert():ArrayList<MultipleItemEntity>

    fun setJsonData(json: String):DataConverter{
        mJsonData = json
        return this
    }

    fun clearData(){
        mEntities.clear()
    }
}