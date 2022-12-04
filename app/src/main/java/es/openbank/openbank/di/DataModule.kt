package es.openbank.openbank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.openbank.data.datasources.RemoteDataSource
import es.openbank.data.repositories.HeroRepositoryImpl
import es.openbank.domain.repository.HeroRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun heroRepositoryProvider(remoteDataSource: RemoteDataSource) : HeroRepository {
        return HeroRepositoryImpl(remoteDataSource)
    }
}