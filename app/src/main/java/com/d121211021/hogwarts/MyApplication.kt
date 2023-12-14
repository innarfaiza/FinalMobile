package com.d121211021.hogwarts

import android.app.Application
import com.d121211021.hogwarts.data.AppContainer
import com.d121211021.hogwarts.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}