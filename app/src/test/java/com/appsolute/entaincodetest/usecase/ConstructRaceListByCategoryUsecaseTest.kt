package com.appsolute.entaincodetest.usecase

import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.model.RaceCategory
import com.appsolute.entaincodetest.domain.usecase.ConstructRaceListByCategoryUsecase
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.Clock
import org.junit.Before
import org.junit.Test
import kotlin.time.DurationUnit
import kotlin.time.toDuration

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 3/11/2023, Friday
 **/
class ConstructRaceListByCategoryUsecaseTest {
    private lateinit var constructRaceListByCategoryUsecase: ConstructRaceListByCategoryUsecase

    private val mockAvailableRaceList = listOf(
        AvailableRace(
            raceId = "dissentiunt",
            advertisedStartInSecond = Clock.System.now().plus(1.toDuration(DurationUnit.DAYS)).epochSeconds.toInt(),
            category = RaceCategory.Harness,
            meetingName = "Sheree Fischer",
            venueCountry = "Finland"
        ),
        AvailableRace(
            raceId = "malesuada",
            advertisedStartInSecond = Clock.System.now().plus(1.toDuration(DurationUnit.DAYS)).epochSeconds.toInt(),
            category = RaceCategory.Harness,
            meetingName = "Omar Lara",
            venueCountry = "Finland"
        ),
        AvailableRace(
            raceId = "dicta",
            advertisedStartInSecond = Clock.System.now().plus(1.toDuration(DurationUnit.DAYS)).epochSeconds.toInt(),
            category = RaceCategory.Greyhound,
            meetingName = "Elva Conner",
            venueCountry = "East Timor (see Timor-Leste)"
        ),
        AvailableRace(
            raceId = "venenatis",
            advertisedStartInSecond = Clock.System.now().plus(1.toDuration(DurationUnit.DAYS)).epochSeconds.toInt(),
            category = RaceCategory.Greyhound,
            meetingName = "Mattie Martin",
            venueCountry = "Kuwait"
        ),
        AvailableRace(
            raceId = "vestibulum",
            advertisedStartInSecond = Clock.System.now().plus(1.toDuration(DurationUnit.DAYS)).epochSeconds.toInt(),
            category = RaceCategory.Horse,
            meetingName = "Kristopher York",
            venueCountry = "Croatia"
        ),
        AvailableRace(
            raceId = "pretium",
            advertisedStartInSecond = Clock.System.now().plus(1.toDuration(DurationUnit.DAYS)).epochSeconds.toInt(),
            category = RaceCategory.Horse,
            meetingName = "Reggie Rivas",
            venueCountry = "Tunisia"
        ),
    )

    @Before
    fun setUp(){
        constructRaceListByCategoryUsecase = ConstructRaceListByCategoryUsecase()
    }

    @Test
    fun `Given a list of available races, expect to have a map result with 3 required categories`(){
        runBlocking {
            val categoryMap = constructRaceListByCategoryUsecase(mockAvailableRaceList)
            assert(categoryMap.keys.isNotEmpty())
        }
    }

    @Test
    fun `Given a list of available races, expect to have a map result with Greyhound, Horse and Harness categories`(){
        runBlocking {
            val categoryMap = constructRaceListByCategoryUsecase(mockAvailableRaceList)
            assert(categoryMap.keys.contains(RaceCategory.Harness))
            assert(categoryMap.keys.contains(RaceCategory.Greyhound))
            assert(categoryMap.keys.contains(RaceCategory.Horse))
        }
    }

    @Test
    fun `Given a list of available races, expect to have each categories it exact available list`(){
        runBlocking {
            val categoryMap = constructRaceListByCategoryUsecase(mockAvailableRaceList)
            assert(categoryMap[RaceCategory.Harness]?.size == 2)
            assert(categoryMap[RaceCategory.Greyhound]?.size == 2)
            assert(categoryMap[RaceCategory.Horse]?.size == 2)
        }
    }
}