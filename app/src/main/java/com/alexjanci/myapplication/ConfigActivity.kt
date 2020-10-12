package com.alexjanci.myapplication

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class ConfigActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.config_activity)
        setResult(RESULT_CANCELED)
        val setupWidget = findViewById<View>(R.id.setupWidget) as Button
        setupWidget.setOnClickListener { handleSetupWidget() }
        val configButton = findViewById<View>(R.id.configButton) as Button
        configButton.setOnClickListener { handleConfigWidget() }
    }

    private fun handleSetupWidget() {
        showAppWidget()
    }

    private fun handleConfigWidget() {
        Toast.makeText(
            this@ConfigActivity,
            "Configuration options", Toast.LENGTH_LONG
        ).show()
    }

    var appWidgetId = 0
    private fun showAppWidget() {
        appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
        val intent = intent
        val extras = intent.extras
        if (extras != null) {
            appWidgetId = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
            if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                finish()
            }

            //TO do: Perform the configuration//
            val resultValue = Intent()
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            setResult(RESULT_OK, resultValue)
            finish()
        }
    }
}