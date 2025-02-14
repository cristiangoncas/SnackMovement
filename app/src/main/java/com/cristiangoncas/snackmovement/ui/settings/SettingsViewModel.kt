package com.cristiangoncas.snackmovement.ui.settings

import androidx.lifecycle.ViewModel
import com.cristiangoncas.snackmovement.domain.NotificationSchedule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state get() = _state.asStateFlow()
}

data class SettingsState(
    val notifications: List<NotificationSchedule> = listOf(
        NotificationSchedule(
            id = 1,
            startTime = "08:00",
            endTime = "15:00",
            frequency = 30,
            isActive = true,
        ),
        NotificationSchedule(
            id = 2,
            startTime = "17:00",
            endTime = "20:00",
            frequency = 45,
            isActive = false,
        ),
    ),
)
