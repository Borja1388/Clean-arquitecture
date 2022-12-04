package es.openbank.domain.repository

import es.openbank.domain.model.Hero

interface HeroRepository {
    suspend fun getHeroes(): Result<List<Hero>>
}