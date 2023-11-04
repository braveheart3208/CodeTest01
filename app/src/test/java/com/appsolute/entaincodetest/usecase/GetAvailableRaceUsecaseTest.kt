package com.appsolute.entaincodetest.usecase

import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.model.RaceCategory
import com.appsolute.entaincodetest.domain.repository.RacesRepository
import com.appsolute.entaincodetest.domain.usecase.ConstructRaceListByCategoryUsecase
import com.appsolute.entaincodetest.domain.usecase.GetAvailableRaceUsecase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 4/11/2023, Saturday
 **/

class GetAvailableRaceUsecaseTest {

    private lateinit var getAvailableRaceUsecase: GetAvailableRaceUsecase

    private val RACE_COUNT = 100

    @Test
    fun `Whenever calling the API, success return SUCCESS result`() {
        runBlocking {
            val raceRepo = mockk<RacesRepository>(relaxed = true)
            every {
                runBlocking {
                    raceRepo.getNextRaces(RACE_COUNT)
                }
            } returns Result.success(listOf())
            getAvailableRaceUsecase = GetAvailableRaceUsecase(raceRepo)
            val result = getAvailableRaceUsecase(RACE_COUNT)
            assert(result.isSuccess)
        }
    }

    @Test
    fun `Whenever calling the API, success return FAILURE result`() {
        runBlocking {
            val raceRepo = mockk<RacesRepository>(relaxed = true)
            every {
                runBlocking {
                    raceRepo.getNextRaces(RACE_COUNT)
                }
            } returns Result.failure(exception = Exception())
            getAvailableRaceUsecase = GetAvailableRaceUsecase(raceRepo)
            val result = getAvailableRaceUsecase(RACE_COUNT)
            assert(result.isFailure)
        }
    }
}