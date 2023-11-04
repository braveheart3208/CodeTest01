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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.appsolute.entaincodetest.domain.model.AvailableRace
import com.appsolute.entaincodetest.domain.model.RaceCategory
import com.appsolute.entaincodetest.domain.model.description

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 3/11/2023, Friday
 **/

@Composable
fun RaceCategoryEntryComponent(
    modifier: Modifier = Modifier,
    raceCategory: RaceCategory
) {
    Row(
        modifier = modifier.fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = raceCategory.description(),
            color = Color.Black,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}