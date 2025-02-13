package com.cristiangoncas.snackmovement.ui.screens.notifications

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotificationsViewModel : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state get() = _state.asStateFlow()
}

data class UIState(
    val text: String = "This is notifications screen",
)
