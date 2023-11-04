package com.appsolute.entaincodetest

import com.appsolute.entaincodetest.data.mapper.toAvailableRace
import com.appsolute.entaincodetest.data.remote.dto.AdvertisedStart
import com.appsolute.entaincodetest.data.remote.dto.RaceSummaries
import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.model.RaceCategory
import org.junit.Test

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 5/11/2023, Sunday
 **/

class AvailableRaceMapperTest {
    private val mockRaceSummariesList = listOf(
        RaceSummaries(
            advertised_start = AdvertisedStart(4522),
            category_id = "161d9be2-e909-4326-8c2c-35ed71fb460b",
            meeting_id = null,
            meeting_name = "Omar Lara",
            race_id = "malesuada",
            race_name = null,
            race_number = null,
            venue_country = "Finland",
            venue_id = null,
            venue_name = null,
            venue_state = null
        )
    )

    @Test
    fun `Given a list of RaceSummaries, expect map into a list of AvailableRaces correctly`(){
        val mappedAvailableRaceList = mockRaceSummariesList.map { it.toAvailableRace() }

        assert(mappedAvailableRaceList.first().raceId == "malesuada")
        assert(mappedAvailableRaceList.first().category is RaceCategory.Harness)
        assert(mappedAvailableRaceList.first().advertisedStartInSecond == 4522)
        assert(mappedAvailableRaceList.first().meetingName == "Omar Lara")
        assert(mappedAvailableRaceList.first().venueCountry == "Finland")
    }
}