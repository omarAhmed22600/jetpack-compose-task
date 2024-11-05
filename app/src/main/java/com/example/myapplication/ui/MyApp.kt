package com.example.myapplication.ui

import androidx.annotation.CallSuper
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MyApp : MultiDexApplication() {
    @CallSuper
    override fun onCreate() {
        super.onCreate()
        Timber.plant(LineNumberDebugTree())
    }
    class LineNumberDebugTree : Timber.DebugTree() {
        override fun createStackElementTag(element: StackTraceElement): String {
            return "(${element.fileName}:${element.lineNumber})#${element.methodName}"
        }
    }
}