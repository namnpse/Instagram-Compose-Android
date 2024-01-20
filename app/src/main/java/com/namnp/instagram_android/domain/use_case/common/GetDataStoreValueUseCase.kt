package com.namnp.instagram_android.domain.use_case.common

import com.namnp.instagram_android.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetDataStoreValueUseCase(
    private val repository: Repository
) {
    operator fun invoke(key: String): Flow<String> {
        return repository.getDataStoreValueByKey(key)
    }
}