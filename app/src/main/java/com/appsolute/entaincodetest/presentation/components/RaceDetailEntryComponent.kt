package com.appsolute.entaincodetest.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.appsolute.entaincodetest.domain.model.AvailableRace

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 3/11/2023, Friday
 **/

@Composable
fun RaceDetailEntryComponent(
    modifier: Modifier = Modifier,
    race: AvailableRace,
    onTimeUp: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "${race.meetingName} ${race.venueCountry}",
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyMedium,
        )

        CountDownTimerView(
            initialValue = race.advertisedStartInSecond.toLong(),
            onTimesUp = onTimeUp,
            modifier = Modifier
        )
    }
}