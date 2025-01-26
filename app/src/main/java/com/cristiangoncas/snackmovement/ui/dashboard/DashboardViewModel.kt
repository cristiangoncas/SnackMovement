package com.cristiangoncas.snackmovement.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state get() = _state.asStateFlow()
}

data class UIState(
    val text: String = "This is dashboard screen",
)