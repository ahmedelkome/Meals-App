package com.route.meals_app.mealsapp

import android.app.Application
import com.route.meals_app.data.utils.ConnectivityChecker
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ConnectivityChecker.context = this
    }
}