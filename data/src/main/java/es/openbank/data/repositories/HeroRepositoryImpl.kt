package es.openbank.data.repositories

import es.openbank.data.datasources.RemoteDataSource
import es.openbank.domain.model.Hero
import es.openbank.domain.repository.HeroRepository

class HeroRepositoryImpl(private val remoteDataSource: RemoteDataSource): HeroRepository {

    override suspend fun getHeroes(): Result<List<Hero>> = remoteDataSource.getHeroes()
}

