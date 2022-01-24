package com.wanted.wantedproject

import android.app.Application
import com.wanted.wantedproject.repository.SettingRepository
import timber.log.Timber

class SaiApplication : Application() {

    private lateinit var dataStore: SettingRepository

    companion object {
        private lateinit var saiApplication: SaiApplication
        fun getInstance(): SaiApplication = saiApplication
    }
    override fun onCreate() {
        super.onCreate()
        saiApplication = this
        dataStore = SettingRepository(saiApplication)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
    fun getDataStore() : SettingRepository = dataStore
}