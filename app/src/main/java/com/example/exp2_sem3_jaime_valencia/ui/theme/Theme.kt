package com.example.exp2_sem3_jaime_valencia.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Bootstrap Color Palette
private val BootstrapPrimary = Color(0xFF0D6EFD)
private val BootstrapSecondary = Color(0xFF6C757D)
private val BootstrapSuccess = Color(0xFF198754)
private val BootstrapDanger = Color(0xFFDC3545)
private val BootstrapWarning = Color(0xFFFFC107)
private val BootstrapInfo = Color(0xFF0DCAF0)
private val BootstrapLight = Color(0xFFF8F9FA)
private val BootstrapDark = Color(0xFF212529)

// Additional Bootstrap-inspired colors
private val BootstrapWhite = Color(0xFFFFFFFF)
private val BootstrapMuted = Color(0xFF6C757D)
private val BootstrapBorder = Color(0xFFDEE2E6)

private val LightColorScheme = lightColorScheme(
    primary = BootstrapPrimary,
    onPrimary = BootstrapWhite,
    primaryContainer = Color(0xFFCFE2FF),
    onPrimaryContainer = Color(0xFF031633),
    secondary = BootstrapSecondary,
    onSecondary = BootstrapWhite,
    secondaryContainer = Color(0xFFE2E3E5),
    onSecondaryContainer = Color(0xFF1C1E21),
    tertiary = BootstrapInfo,
    onTertiary = BootstrapDark,
    tertiaryContainer = Color(0xFFCFF4FC),
    onTertiaryContainer = Color(0xFF032830),
    error = BootstrapDanger,
    errorContainer = Color(0xFFFFDAD6),
    onError = BootstrapWhite,
    onErrorContainer = Color(0xFF410002),
    background = BootstrapWhite,
    onBackground = BootstrapDark,
    surface = BootstrapWhite,
    onSurface = BootstrapDark,
    surfaceVariant = BootstrapLight,
    onSurfaceVariant = Color(0xFF495057),
    outline = BootstrapBorder,
    inverseOnSurface = BootstrapLight,
    inverseSurface = BootstrapDark,
    inversePrimary = Color(0xFF9FC5FF)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF9FC5FF),
    onPrimary = Color(0xFF031633),
    primaryContainer = Color(0xFF0A4A90),
    onPrimaryContainer = Color(0xFFCFE2FF),
    secondary = Color(0xFFADB5BD),
    onSecondary = Color(0xFF1C1E21),
    secondaryContainer = Color(0xFF495057),
    onSecondaryContainer = Color(0xFFE2E3E5),
    tertiary = Color(0xFF76D7EA),
    onTertiary = Color(0xFF032830),
    tertiaryContainer = Color(0xFF0A525C),
    onTertiaryContainer = Color(0xFFCFF4FC),
    error = Color(0xFFFFB4AB),
    errorContainer = Color(0xFF93000A),
    onError = Color(0xFF410002),
    onErrorContainer = Color(0xFFFFDAD6),
    background = Color(0xFF121212),
    onBackground = Color(0xFFE3E3E3),
    surface = Color(0xFF1C1B1F),
    onSurface = Color(0xFFE3E3E3),
    surfaceVariant = Color(0xFF343A40),
    onSurfaceVariant = Color(0xFFADB5BD),
    outline = Color(0xFF495057),
    inverseOnSurface = Color(0xFF1C1B1F),
    inverseSurface = Color(0xFFE3E3E3),
    inversePrimary = BootstrapPrimary
)

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = TitleFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = TitleFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = TitleFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = CustomFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

@Composable
fun ChileanRecipesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

object AppColors {
    val CaloriesColor = BootstrapDanger
    val ProteinsColor = BootstrapInfo
    val DifficultyEasy = BootstrapSuccess
    val DifficultyMedium = BootstrapWarning
    val DifficultyHard = BootstrapDanger
    val CardBackground = BootstrapLight
    val DividerColor = BootstrapBorder
    val BreakfastColor = Color(0xFFFFD85D)
    val LunchColor = Color(0xFF53D1E8)
    val SnackColor = Color(0xFFEEB427)
    val DinnerColor = Color(0xFF4C4EF6)
    val Primary = BootstrapPrimary
    val Secondary = BootstrapSecondary
    val Success = BootstrapSuccess
    val Danger = BootstrapDanger
    val Warning = BootstrapWarning
    val Info = BootstrapInfo
    val Light = BootstrapLight
    val Dark = BootstrapDark
    val White = BootstrapWhite
    val Muted = BootstrapMuted
}