package com.appsolute.entaincodetest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.appsolute.entaincodetest.domain.model.RaceCategory
import com.appsolute.entaincodetest.domain.model.description

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 3/11/2023, Friday
 **/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownFilterComponent(
    modifier: Modifier = Modifier,
    isInitiallyOpening: Boolean = false,
    categories: Map<RaceCategory, Boolean> = emptyMap(),
    onItemFilterClicked: (RaceCategory) -> Unit
) {
    var isOpening by remember {
        mutableStateOf(isInitiallyOpening)
    }

    ExposedDropdownMenuBox(
        expanded = isOpening,
        onExpandedChange = { isOpening = it },
        modifier = modifier,
    ) {
        TextField(
            enabled = true,
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = "Filter Options",
            onValueChange = {},
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isOpening)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )
        ExposedDropdownMenu(expanded = isOpening, onDismissRequest = { isOpening = !isOpening }) {
            categories.keys.forEach {
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = categories[it] ?: false,
                                onCheckedChange = {},
                            )
                            Text(
                                text = it.description(),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    onClick = {
                        onItemFilterClicked(it)
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}