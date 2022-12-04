package es.openbank.openbank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.openbank.domain.repository.HeroRepository
import es.openbank.usecases.LoadHero
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
     fun providerUseCase(repository: HeroRepository): LoadHero =
         LoadHero(repository)
}