package com.appsolute.entaincodetest.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/

@Composable
fun CountDownTimerView(
    initialValue: Long,
    onTimesUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    var currentCountdownValue by remember {
        mutableLongStateOf(initialValue - Clock.System.now().epochSeconds)
    }

    LaunchedEffect(key1 = currentCountdownValue) {
        if (currentCountdownValue > 0) {
            delay(1000L)
            currentCountdownValue -= 1
        } else {
            onTimesUp()
        }
    }

    Box(modifier = modifier.fillMaxHeight()) {
        Text(text = currentCountdownValue.formatToMMSS(), fontSize = 19.sp, color = Color.Blue)
    }
}

fun Long.formatToMMSS(): String {
    return "${(this / 60).toString().padStart(2, '0')} min: ${
        (this % 60).toString().padStart(2, '0')
    } sec"
}