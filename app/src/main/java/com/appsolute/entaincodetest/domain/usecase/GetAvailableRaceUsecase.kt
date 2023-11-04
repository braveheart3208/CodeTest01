package com.appsolute.entaincodetest.domain.usecase

import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.model.RaceCategory
import com.appsolute.entaincodetest.domain.repository.RacesRepository
import kotlinx.datetime.Clock
import javax.inject.Inject

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
class GetAvailableRaceUsecase @Inject constructor(
    private val racesRepository: RacesRepository
) {
    suspend operator fun invoke(numberOfRace: Int): Result<List<AvailableRace>> {
        if (numberOfRace > 0) {
            return racesRepository.getNextRaces(numberOfRace)
        }

        return Result.success(emptyList())
    }
}