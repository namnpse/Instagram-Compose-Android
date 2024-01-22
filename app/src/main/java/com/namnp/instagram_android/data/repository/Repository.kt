package com.namnp.instagram_android.data.repository

import com.namnp.instagram_android.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository
@Inject
constructor(
    private val dataStore: DataStoreOperations
) {

    fun getDataStoreValueByKey(key: String): Flow<String> {
        return dataStore.getDataStoreValueByKey(key)
    }

    suspend fun setDataStoreValueByKey(key: String?, value: String?) {
        dataStore.setDataStoreValueByKey(key, value)
    }

    suspend fun clearUserInfo() = dataStore.clearUserInfo()

}