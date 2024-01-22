package com.namnp.instagram_android.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {

    fun getDataStoreValueByKey(key: String): Flow<String>

    suspend fun setDataStoreValueByKey(key: String?, value: String?)

    suspend fun clearUserInfo()
}