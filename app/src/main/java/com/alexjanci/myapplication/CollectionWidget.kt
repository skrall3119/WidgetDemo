package com.alexjanci.myapplication

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.Toast

class CollectionWidget : AppWidgetProvider() {

    companion object {
        fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
            val views = RemoteViews(context.packageName, R.layout.list_widget)
            setRemoteAdapter(context, views)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
        private fun setRemoteAdapter(context: Context, views: RemoteViews){
            views.setRemoteAdapter(R.id.widget_list, Intent(context, WidgetService::class.java))
        }
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for(appWidgetId in appWidgetIds){
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    override fun onEnabled(context: Context?) {
        Toast.makeText(context, "onEnabled called", Toast.LENGTH_LONG).show()
    }

    override fun onDisabled(context: Context?) {
        Toast.makeText(context, "onDisabled called", Toast.LENGTH_LONG).show()
    }
}