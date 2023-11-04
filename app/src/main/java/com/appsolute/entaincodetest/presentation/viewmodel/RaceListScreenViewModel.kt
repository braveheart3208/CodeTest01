package com.appsolute.entaincodetest.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsolute.entaincodetest.domain.model.RaceCategory
import com.appsolute.entaincodetest.domain.usecase.ConstructRaceListByCategoryUsecase
import com.appsolute.entaincodetest.domain.usecase.GetAvailableRaceUsecase
import com.appsolute.entaincodetest.presentation.RaceListScreenEvent
import com.appsolute.entaincodetest.presentation.RaceListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 2/11/2023, Thursday
 **/
@HiltViewModel
class RaceListScreenViewModel @Inject constructor(
    private val getAvailableRaceUsecase: GetAvailableRaceUsecase,
    private val constructRaceListByCategoryUsecase: ConstructRaceListByCategoryUsecase
) : ViewModel() {
    private val _state = mutableStateOf(RaceListScreenState())
    val state: State<RaceListScreenState> = _state

    private var fetchRaceListJob: Job? = null

    private val DESIRED_NO_OF_COUNT = 20

    init {
        fetchRaceList()
    }

    fun onEventCalled(event: RaceListScreenEvent) {
        when (event) {
            is RaceListScreenEvent.OnRaceTimerUp -> {
                _state.value = _state.value.copy(
                    displayingRaceList = emptyMap()
                )
            }

            is RaceListScreenEvent.OnFilterRaceCategoryClicked -> {
                val updatedSelectedCategory = mutableMapOf<RaceCategory, Boolean>()
                updatedSelectedCategory.putAll(_state.value.selectedCategories)
                updatedSelectedCategory[event.raceCategory]?.let {
                    updatedSelectedCategory[event.raceCategory] = !it
                }
                _state.value = _state.value.copy(
                    selectedCategories = updatedSelectedCategory
                )

                updateDisplayRaceListByFilter()
            }

            is RaceListScreenEvent.OnRefreshClicked -> {
                fetchRaceList()
            }
        }
    }

    private fun fetchRaceList() {
        fetchRaceListJob?.cancel()

        _state.value = _state.value.copy(hasError = false)

        fetchRaceListJob = viewModelScope.launch {
            _state.value = _state.value.copy(isFetchingRaceList = true)
            getAvailableRaceUsecase(DESIRED_NO_OF_COUNT)
                .onSuccess {
                    _state.value = _state.value.copy(isFetchingRaceList = false)
                    _state.value = _state.value.copy(availableRaceList = it)

                    updateDisplayRaceListByFilter()
                }
                .onFailure {
                    _state.value = _state.value.copy(isFetchingRaceList = false)
                    _state.value = _state.value.copy(hasError = true)
                }
        }
    }

    private fun updateDisplayRaceListByFilter() {
        val selectedCategories = _state.value.selectedCategories.filter { it.value }.keys
        _state.value = _state.value.copy(
            displayingRaceList = constructRaceListByCategoryUsecase(_state.value.availableRaceList)
                .filter {
                    selectedCategories.contains(it.key)
                }
        )
    }
}