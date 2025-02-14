package com.cristiangoncas.snackmovement.ui.settings

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.cristiangoncas.snackmovement.domain.NotificationSchedule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class NotificationModalState(
    val sheetState: SheetState,
    val scope: CoroutineScope,
    val onSubmit: (NotificationSchedule) -> Unit,
) {
    var isExpanded by mutableStateOf(false)
    var startTime by mutableStateOf("")
    var endTime by mutableStateOf("")
    var frequency by mutableIntStateOf(0)

    fun scheduleNotification() {
        onSubmit(
            NotificationSchedule(
                id = 1,
                startTime = startTime,
                endTime = endTime,
                frequency = frequency,
                isActive = true
            )
        )
        dismiss()
    }

    fun cancel() {
        dismiss()
    }

    private fun dismiss() {
        scope.launch { sheetState.hide() }.invokeOnCompletion {
            if (!sheetState.isVisible) {
                isExpanded = false
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun rememberNotificationModalState(
    onSubmit: (NotificationSchedule) -> Unit,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    scope: CoroutineScope = rememberCoroutineScope(),
): NotificationModalState {
    return remember {
        NotificationModalState(
            onSubmit = onSubmit,
            sheetState = sheetState,
            scope = scope,
        )
    }
}
