package com.namnp.instagram_android.domain.use_case.common

import com.namnp.instagram_android.data.repository.Repository

class SetDataStoreValueUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(key: String?, value: String?) {
        return repository.setDataStoreValueByKey(key, value)
    }
}