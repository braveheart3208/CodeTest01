package com.appsolute.entaincodetest.data.remote

import com.appsolute.entaincodetest.data.remote.dto.GetNextRacesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
interface RacesApi {
    companion object{
        const val NEDS_BASE_URL = "https://api.neds.com.au/"
    }

    @GET("/rest/v1/racing/?method=nextraces")
    suspend fun getNextRaces(@Query("count") numberOfRace: Int): GetNextRacesResponse
}