package com.cristiangoncas.snackmovement.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.cristiangoncas.snackmovement.R

private val DarkColorScheme = darkColorScheme(
    primary = Purple200,
    primaryContainer = Purple700,
    onPrimaryContainer = Black,
    secondary = Teal200,
    secondaryContainer = Teal200,
    onSecondaryContainer = Black,
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple500,
    primaryContainer = Purple700,
    onPrimaryContainer = White,
    secondary = Teal200,
    secondaryContainer = Teal700,
    onSecondaryContainer = Black,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
)

val outfitFontFamily = FontFamily(
    Font(R.font.outfit_regular, weight = FontWeight.Normal)
)
private val defaultTypography = Typography()

val AppTypography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = outfitFontFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = outfitFontFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = outfitFontFamily),
    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = outfitFontFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = outfitFontFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = outfitFontFamily),
    titleLarge = defaultTypography.titleLarge.copy(fontFamily = outfitFontFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = outfitFontFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = outfitFontFamily),
    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = outfitFontFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = outfitFontFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = outfitFontFamily),
    labelLarge = defaultTypography.labelLarge.copy(fontFamily = outfitFontFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = outfitFontFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = outfitFontFamily)
)

@Composable
fun SnackMovementTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content,
    )
}
