package com.appsolute.entaincodetest.data.repository

import com.appsolute.entaincodetest.data.mapper.toAvailableRace
import com.appsolute.entaincodetest.data.remote.RacesApi
import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.repository.RacesRepository
/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
class RacesRepositoryImpl(
    private val racesApi: RacesApi
) : RacesRepository {

    override suspend fun getNextRaces(count: Int): Result<List<AvailableRace>> {
        return try {
            val getAvailableRacesResponse = racesApi.getNextRaces(count)
            val availableRace = mutableListOf<AvailableRace>()
            getAvailableRacesResponse.data?.race_summaries?.map { (_, raceSummary) ->
                raceSummary?.let {
                    availableRace.add(it.toAvailableRace())
                }
            }
            Result.success(availableRace)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}