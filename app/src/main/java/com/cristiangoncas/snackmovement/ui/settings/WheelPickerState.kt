package com.cristiangoncas.snackmovement.ui.settings

import android.view.HapticFeedbackConstants
import android.view.View
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.cristiangoncas.snackmovement.ui.theme.Black
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class WheelPickerState<T>(
    val items: List<T>,
    val view: View,
    val density: Density,
    val textStyle: TextStyle,
    val lazyListState: LazyListState,
    val coroutineScope: CoroutineScope,
    val onItemSelected: (item: T) -> Unit,
) {
    val itemHeight = 48.dp
    val numberOfDisplayedItems = 3
    val itemScaleFact: Float = 1.5f
    val itemHalfHeight = density.run { itemHeight.toPx() / 2f }

    var initialItem: T? = null

    fun scrollToInitialItem(onIndexChange: (Int) -> Unit) {
        initialItem?.let {
            coroutineScope.launch {
                var targetIndex = items.indexOf(initialItem) - 1
                targetIndex += ((Int.MAX_VALUE / 2) / items.size) * items.size
                onIndexChange(targetIndex)
                lazyListState.scrollToItem(targetIndex)
            }
        }
    }

    fun adjustScroll(
        index: Int,
        item: T,
        lastSelectedIndex: Int,
        coordinates: LayoutCoordinates,
        onIndexChange: (Int) -> Unit,
    ) {
        val y = coordinates.positionInParent().y - itemHalfHeight
        val parentHalfHeight = (itemHalfHeight * numberOfDisplayedItems)
        val isSelected =
            (y > parentHalfHeight - itemHalfHeight && y < parentHalfHeight + itemHalfHeight)
        if (isSelected && lastSelectedIndex != index - 1) {
            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
            onItemSelected(item)
            onIndexChange(index - 1)
        }
    }

    fun getItemTextColor(index: Int, lastSelectedIndex: Int): Color =
        if (lastSelectedIndex == index) {
            Black
        } else {
            Black.copy(alpha = 0.5f)
        }

    fun getItemFontSize(index: Int, lastSelectedIndex: Int): TextUnit =
        if (lastSelectedIndex == index) {
            textStyle.fontSize * itemScaleFact
        } else {
            textStyle.fontSize
        }

    fun getItem(index: Int): T = items[index % items.size]

    fun printNumberItem(item: T): String =
        if (item.toString().length == 1) "0$item" else item.toString()

    fun getWheelHeight(): Dp = itemHeight * numberOfDisplayedItems
}

@Composable
fun <T> rememberWheelPickerState(
    items: List<T>,
    view: View = LocalView.current,
    density: Density = LocalDensity.current,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
    lazyListState: LazyListState = rememberLazyListState(0),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    onItemSelected: (item: T) -> Unit,
): WheelPickerState<T> {
    return remember {
        WheelPickerState<T>(
            items = items,
            view = view,
            density = density,
            textStyle = textStyle,
            lazyListState = lazyListState,
            coroutineScope = coroutineScope,
            onItemSelected = onItemSelected,
        )
    }
}
