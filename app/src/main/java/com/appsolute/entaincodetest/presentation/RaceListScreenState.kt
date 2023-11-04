package com.appsolute.entaincodetest.presentation

import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.model.RaceCategory

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
data class RaceListScreenState(
    val isFetchingRaceList: Boolean = false,
    val availableRaceList: List<AvailableRace> = emptyList(),
    val displayingRaceList: Map<RaceCategory, List<AvailableRace>> = emptyMap(),
    val selectedCategories: Map<RaceCategory, Boolean> = mapOf(
        RaceCategory.Horse to true,
        RaceCategory.Harness to true,
        RaceCategory.Greyhound to true
    ),
    val hasError : Boolean = false
)
