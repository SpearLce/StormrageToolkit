package com.illidancstormrage.mainapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import com.illidancstormrage.utils.extensions.javaClassName
import com.illidancstormrage.utils.initializer.CStormrageToolkitInitializer
import com.illidancstormrage.utils.log.LogUtil
import kotlin.math.log

class MainApplication : Application() { //manifest xml name属性
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        private const val TAG = "MainApplication"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        //LogUtil.d(msg = this.javaClassName)

        CStormrageToolkitInitializer.initialize {
            initializeLogLevel(LogUtil.DEBUG)
            initializeContext(applicationContext)
        }

    }
}