package com.wanted.wantedproject.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import timber.log.Timber


class SettingRepository(private val context: Context) {
    private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore(name = "sai_setting")

    private val VISIBLE_TOOLBAR = booleanPreferencesKey("visible_toolbar")

    val toolbarModeFlow: Flow<Boolean> = context.dataStore.data
        .catch { exception ->
            Timber.d(exception)
        }
        .map { preferences ->
            preferences[VISIBLE_TOOLBAR] ?: true
        }

    suspend fun setToolbarVisibility(isVisible: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[VISIBLE_TOOLBAR] = isVisible
        }
    }
}