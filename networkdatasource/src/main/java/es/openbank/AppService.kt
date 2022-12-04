package es.openbank

import es.openbank.data.models.HeroDto
import es.openbank.domain.model.Hero
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface AppService {

    @GET("characters")
    suspend fun getHeroes(): List<HeroDto>

    companion object {
        private const val BASE_URL =
            "https://hp-api.herokuapp.com/api/"

        fun create(): AppService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client = OkHttpClient.Builder().addInterceptor(logger)
                .build()
            return Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create()).build()
                .create(AppService::class.java)
        }
    }
}