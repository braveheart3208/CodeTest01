package com.appsolute.entaincodetest.domain.model

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
data class AvailableRace(
    val raceId : String,
    val advertisedStartInSecond : Int,
    val category : RaceCategory,
    val meetingName : String,
    val venueCountry : String,
)
