package com.wanted.wantedproject

import android.app.Application
import timber.log.Timber

class SaiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}