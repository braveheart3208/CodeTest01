package com.appsolute.entaincodetest.data._di

import com.appsolute.entaincodetest.data.remote.RacesApi
import com.appsolute.entaincodetest.data.repository.RacesRepositoryImpl
import com.appsolute.entaincodetest.domain.repository.RacesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
@Module
@InstallIn(SingletonComponent::class)
object RacesModule {
    @Provides
    @Singleton
    fun providesRacesApi(): RacesApi {
        return Retrofit.Builder()
            .baseUrl(RacesApi.NEDS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .build()
            )
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesRacesRepository(racesApi: RacesApi): RacesRepository = RacesRepositoryImpl(racesApi)
}