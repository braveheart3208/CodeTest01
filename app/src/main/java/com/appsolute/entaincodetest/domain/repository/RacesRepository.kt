package com.appsolute.entaincodetest.domain.repository

import com.appsolute.entaincodetest.domain.model.AvailableRace

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
interface RacesRepository {
    suspend fun getNextRaces(count : Int) : Result<List<AvailableRace>>
}