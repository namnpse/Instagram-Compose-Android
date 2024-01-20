package com.namnp.instagram_android.domain.use_case

import com.namnp.instagram_android.domain.use_case.common.GetDataStoreValueUseCase
import com.namnp.instagram_android.domain.use_case.common.SetDataStoreValueUseCase

data class UseCases(
    val setDataStoreValueUseCase: SetDataStoreValueUseCase,
    val getDataStoreValueUseCase: GetDataStoreValueUseCase,
)