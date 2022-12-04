package es.openbank.data.datasources

import es.openbank.domain.model.Hero

interface RemoteDataSource {
    suspend fun getHeroes(): Result<List<Hero>>
}