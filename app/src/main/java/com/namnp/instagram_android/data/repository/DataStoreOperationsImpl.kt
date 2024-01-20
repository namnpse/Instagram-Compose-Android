package com.namnp.instagram_android.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.namnp.instagram_android.constant.Constants.PREFERENCES_NAME
import com.namnp.instagram_android.domain.repository.DataStoreOperations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreOperationsImpl(context: Context) : DataStoreOperations {

    private object PreferencesKey {

    }

    private val dataStore = context.dataStore

    override fun getDataStoreValueByKey(key: String): Flow<String> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[stringPreferencesKey(key)] ?: ""
            }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun setDataStoreValueByKey(key: String?, value: String?)
            : Unit = withContext(Dispatchers.IO) {
        dataStore.edit { preferences ->
            if (!key.isNullOrEmpty() && !value.isNullOrEmpty())
                preferences[stringPreferencesKey(key)] = value
        }
    }

    override suspend fun clearUserInfo(): Unit = withContext(Dispatchers.IO) {
        dataStore.edit {
            it.clear()
        }
    }

}