package es.openbank.openbank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.openbank.AppService
import es.openbank.ServerHeroDataSource
import es.openbank.data.datasources.RemoteDataSource
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providerAppService(): AppService {
        return AppService.create()
    }

    @Provides
    @Singleton
    fun providerRemoteDataSource(appService: AppService): RemoteDataSource =
        ServerHeroDataSource(appService)
}