package com.example.core.datasource

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.core.PreferenceKeys
import com.example.core.userDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
class UserLocalDataSourceImpl @Inject constructor(
    @ApplicationContext context: Context
) : UserDataSource {
    private val dataStore = context.userDataStore
    override suspend fun saveAccessToken(accessToken: String) {
        dataStore.edit {
            it[PreferenceKeys.ACCESS_TOKEN] = accessToken
        }
    }

    override suspend fun saveAccount(account: String) {
        dataStore.edit {
            it[PreferenceKeys.ACCOUNT] = account
        }
    }

    override suspend fun savePassword(password: String) {
        dataStore.edit {
            it[PreferenceKeys.PASSWORD] = password
        }
    }

    override suspend fun saveRefreshToken(refreshToken: String) {
        dataStore.edit {
            it[PreferenceKeys.REFRESH_TOKEN] = refreshToken
        }
    }

    override suspend fun login() {
    }
}