package com.appsolute.entaincodetest.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.appsolute.entaincodetest.domain.model.RaceCategory
import com.appsolute.entaincodetest.presentation.components.CountDownTimerView
import com.appsolute.entaincodetest.presentation.components.DropdownFilterComponent
import com.appsolute.entaincodetest.presentation.components.RaceCategoryEntryComponent
import com.appsolute.entaincodetest.presentation.components.RaceDetailEntryComponent

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
@Composable
fun RaceListScreen(
    state: RaceListScreenState,
    onEventCalled: (RaceListScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        if (state.isFetchingRaceList) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center),
                color = MaterialTheme.colorScheme.primary,
            )
            return
        }

        if (state.hasError) {
            Text(
                text = "Opps, something went wrong",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.error
            )
            return
        }

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DropdownFilterComponent(
                modifier = Modifier.fillMaxWidth(),
                categories = state.selectedCategories,
                onItemFilterClicked = {
                    onEventCalled(RaceListScreenEvent.OnFilterRaceCategoryClicked(it))
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                val availableCategories = state.displayingRaceList.map {
                    it.key
                }

                items(availableCategories) { availableCategory ->
                    RaceCategoryEntryComponent(
                        modifier = Modifier
                            .fillMaxWidth(),
                        raceCategory = availableCategory
                    )
                    state.displayingRaceList[availableCategory]?.let { availableRaces ->
                        availableRaces.forEach { availableRace ->
                            RaceDetailEntryComponent(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                race = availableRace,
                                onTimeUp = {
                                    onEventCalled(RaceListScreenEvent.OnRaceTimerUp(availableRace))
                                }
                            )
                        }
                    }

                    HorizontalDivider(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}