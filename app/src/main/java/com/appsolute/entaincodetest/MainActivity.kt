package com.appsolute.entaincodetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.appsolute.entaincodetest.presentation.RaceListScreen
import com.appsolute.entaincodetest.presentation.RaceListScreenEvent
import com.appsolute.entaincodetest.presentation.viewmodel.RaceListScreenViewModel
import com.appsolute.entaincodetest.ui.theme.EntainCodeTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EntainCodeTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val viewModel = hiltViewModel<RaceListScreenViewModel>()
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    viewModel.onEventCalled(RaceListScreenEvent.OnRefreshClicked)
                                },
                                containerColor = MaterialTheme.colorScheme.secondary,
                                shape = RoundedCornerShape(16.dp),
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Refresh,
                                    contentDescription = "Download New Race List",
                                    tint = Color.White,
                                )
                            }
                        },
                    ) { padding ->
                        RaceListScreen(
                            modifier = Modifier.fillMaxSize().padding(padding),
                            state = viewModel.state.value,
                            onEventCalled = viewModel::onEventCalled
                        )
                    }
                }
            }
        }
    }
}