package com.appsolute.entaincodetest.presentation

import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.model.RaceCategory

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
sealed interface RaceListScreenEvent {
    object OnRefreshClicked : RaceListScreenEvent
    data class OnFilterRaceCategoryClicked(val raceCategory: RaceCategory) : RaceListScreenEvent
    data class OnRaceTimerUp(val race: AvailableRace) : RaceListScreenEvent
}