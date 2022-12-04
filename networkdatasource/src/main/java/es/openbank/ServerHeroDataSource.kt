package es.openbank

import es.openbank.data.datasources.RemoteDataSource
import es.openbank.data.models.toDomain
import es.openbank.domain.model.Hero

class ServerHeroDataSource(private val appService: AppService) : RemoteDataSource {

    override suspend fun getHeroes(): Result<List<Hero>> {
        return runCatching {
            appService.getHeroes().map {
                it.toDomain()
            }
        }
    }
}