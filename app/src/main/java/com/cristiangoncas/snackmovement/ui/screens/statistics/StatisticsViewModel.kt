package com.cristiangoncas.snackmovement.ui.screens.statistics

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StatisticsViewModel : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state get() = _state.asStateFlow()
}

data class UIState(
    val text: String = "This is statistics screen",
)
