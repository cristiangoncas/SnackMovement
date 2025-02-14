package com.cristiangoncas.snackmovement.ui.settings

import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.cristiangoncas.snackmovement.ui.theme.Black
import java.time.LocalTime

@Composable
fun WheelTimePicker() {
    var selectedHour by remember { mutableIntStateOf(0) }
    var selectedMinute by remember { mutableIntStateOf(0) }
    val currentTime by remember { mutableStateOf(LocalTime.now()) }

    val hourWheelState = rememberWheelPickerState(
        items = (0..23).toList(),
        onItemSelected = { selectedHour = it }
    )

    val minuteWheelState = rememberWheelPickerState(
        items = (0..59).toList(),
        onItemSelected = { selectedMinute = it }
    )

    Box {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 48.dp),
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = Black.copy(alpha = 0.2f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 48.dp),
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = Black.copy(alpha = 0.2f),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    WheelPicker(
                        initItem = currentTime.hour,
                        modifier = Modifier.align(Alignment.Center),
                        wheelPickerState = hourWheelState,
                    )
                    Text(
                        text = "h",
                        style = MaterialTheme.typography.titleMedium,
                        color = Black,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(start = 48.dp),
                    )
                }
                Box {
                    WheelPicker(
                        initItem = currentTime.minute,
                        modifier = Modifier.align(Alignment.Center),
                        wheelPickerState = minuteWheelState,
                    )
                    Text(
                        text = "min",
                        style = MaterialTheme.typography.titleMedium,
                        color = Black,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(start = 72.dp),
                    )
                }
            }
        }
    }
}

@Composable
fun <T> WheelPicker(
    initItem: T,
    wheelPickerState: WheelPickerState<T>,
    modifier: Modifier = Modifier,
) {
    with(wheelPickerState) {
        var lastSelectedIndex by remember { mutableIntStateOf(0) }
        var itemsState by remember { mutableStateOf(items) }

        LaunchedEffect(items) {
            initialItem = initItem
            itemsState = items
            scrollToInitialItem { lastSelectedIndex = it }
        }

        LazyColumn(
            modifier = modifier
                .width(80.dp)
                .height(getWheelHeight()),
            state = lazyListState,
            flingBehavior = rememberSnapFlingBehavior(lazyListState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(
                count = Int.MAX_VALUE,
                itemContent = { index ->
                    val item = getItem(index)
                    Box(
                        modifier = Modifier
                            .height(itemHeight)
                            .onGloballyPositioned { coordinates ->
                                adjustScroll(
                                    index = index,
                                    item = item,
                                    lastSelectedIndex = lastSelectedIndex,
                                    coordinates = coordinates
                                ) {
                                    lastSelectedIndex = it
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = printNumberItem(item),
                            style = textStyle,
                            color = getItemTextColor(index, lastSelectedIndex),
                            fontSize = getItemFontSize(index, lastSelectedIndex)
                        )
                    }
                }
            )
        }
    }
}
