package com.appsolute.entaincodetest.domain.usecase

import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.model.RaceCategory
import kotlinx.datetime.Clock
import javax.inject.Inject

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 3/11/2023, Friday
 **/
class ConstructRaceListByCategoryUsecase @Inject constructor() {
    operator fun invoke(availableRaceList: List<AvailableRace>): Map<RaceCategory, List<AvailableRace>> {
        val racesMap = mutableMapOf<RaceCategory, MutableList<AvailableRace>>()
        availableRaceList
            //Only takes 3 required categories
            .filter { availableRace -> availableRace.category != RaceCategory.Other }
            //Filter items that has been older than current timestamp
            .filter { availableRace -> availableRace.advertisedStartInSecond - Clock.System.now().epochSeconds > 0 }
            .forEach { availableRace ->
                if (racesMap[availableRace.category] == null) {
                    racesMap[availableRace.category] = mutableListOf()
                }
                racesMap[availableRace.category]?.let { categoryRaceMap ->
                    if(categoryRaceMap.size < 5){
                        categoryRaceMap.add(availableRace)
                    }
                }
            }
        racesMap.forEach { (_, availableRaceList) ->
            //Sort the list according to advertised start
            availableRaceList.sortBy { it.advertisedStartInSecond }
        }
        return racesMap
    }
}