package com.example.core.util

import android.content.Context
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.userDataStore by preferencesDataStore(
    name = "UserPreferences"
)

object PreferenceKeys {
    val ACCESS_TOKEN = stringPreferencesKey("ACEESS_TOKEN")
    val REFRESH_TOKEN = stringPreferencesKey("REFRESH_TOKEN")
    val ACCOUNT = stringPreferencesKey("ACCOUNT")
    val PASSWORD = stringPreferencesKey("PASSWORD")
    val UNIQUE_NUMBER = stringPreferencesKey("UNIQUE_NUMBER")
    val USER_ID = longPreferencesKey("USER_ID")
}