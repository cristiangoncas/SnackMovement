package com.cristiangoncas.snackmovement.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cristiangoncas.snackmovement.ui.theme.SnackMovementTheme

@Composable
fun Screen(content: @Composable () -> Unit) {

    SnackMovementTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            content = content,
        )
    }
}
