package com.appsolute.entaincodetest.data.mapper

import com.appsolute.entaincodetest.data.remote.dto.RaceSummaries
import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.model.RaceCategory

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/


fun RaceSummaries.toAvailableRace() =
    AvailableRace(
        raceId = this.race_id!!,
        advertisedStartInSecond = this.advertised_start?.seconds!!,
        category = RaceCategory.fromString(this.category_id!!),
        meetingName = this.meeting_name!!,
        venueCountry = this.venue_country!!
    )