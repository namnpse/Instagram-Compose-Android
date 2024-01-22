package com.namnp.instagram_android.di

import android.content.Context
import com.namnp.instagram_android.domain.use_case.common.SetDataStoreValueUseCase
import com.namnp.instagram_android.data.repository.DataStoreOperationsImpl
import com.namnp.instagram_android.data.repository.Repository
import com.namnp.instagram_android.domain.repository.DataStoreOperations
import com.namnp.instagram_android.domain.use_case.UseCases
import com.namnp.instagram_android.domain.use_case.common.GetDataStoreValueUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            setDataStoreValueUseCase = SetDataStoreValueUseCase(repository),
            getDataStoreValueUseCase = GetDataStoreValueUseCase(repository),
        )
    }

}