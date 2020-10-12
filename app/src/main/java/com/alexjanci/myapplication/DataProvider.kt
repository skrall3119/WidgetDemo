package com.alexjanci.myapplication

import android.content.Context
import android.widget.RemoteViews
import android.widget.RemoteViewsService.RemoteViewsFactory
import android.R.layout
import android.R.id
import android.content.Intent

class DataProvider(context: Context?, intent: Intent) :
    RemoteViewsFactory {
    private var myListView: MutableList<String> = ArrayList()
    private var mContext: Context? = null
    override fun onCreate() {
        initData()
    }

    override fun onDataSetChanged() {
        initData()
    }

    override fun onDestroy() {}
    override fun getCount(): Int {
        return myListView.size
    }

    override fun getViewAt(position: Int): RemoteViews {
        val view = RemoteViews(mContext!!.packageName, layout.simple_list_item_1)
        view.setTextViewText(id.text1, myListView[position])
        return view
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    private fun initData() {
        myListView.clear()
        for (i in 1..15) {
            myListView.add("listView item $i")
        }
    }

    init {
        mContext = context
    }
}