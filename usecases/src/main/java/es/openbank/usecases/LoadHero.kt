package es.openbank.usecases

import es.openbank.domain.model.Hero
import es.openbank.domain.repository.HeroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoadHero(private val repository: HeroRepository) {

    suspend operator fun invoke(): Result<List<Hero>> = withContext(Dispatchers.IO) {
        repository.getHeroes()
    }
}