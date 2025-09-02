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




private val ChileanRed = Color(0xFFD32F2F)
private val ChileanGreen = Color(0xFF388E3C)
private val ChileanYellow = Color(0xFFFBC02D)
private val ChileanOrange = Color(0xFFFF8F00)
private val ChileanBrown = Color(0xFF5D4037)
private val WarmWhite = Color(0xFFFFFEF7)
private val SoftGray = Color(0xFFF5F5F5)


private val LightColorScheme = lightColorScheme(
    primary = ChileanGreen,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE8F5E8),
    onPrimaryContainer = Color(0xFF1B5E20),
    secondary = ChileanOrange,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFFF3E0),
    onSecondaryContainer = Color(0xFFE65100),
    tertiary = ChileanYellow,
    onTertiary = Color.Black,
    tertiaryContainer = Color(0xFFFFF8E1),
    onTertiaryContainer = Color(0xFFF57F17),
    error = ChileanRed,
    errorContainer = Color(0xFFFFEBEE),
    onError = Color.White,
    onErrorContainer = ChileanRed,
    background = WarmWhite,
    onBackground = Color(0xFF1C1B1F),
    surface = Color.White,
    onSurface = Color(0xFF1C1B1F),
    surfaceVariant = SoftGray,
    onSurfaceVariant = Color(0xFF49454F),
    outline = Color(0xFF79747E),
    inverseOnSurface = Color(0xFFF4EFF4),
    inverseSurface = Color(0xFF313033),
    inversePrimary = Color(0xFFB2DFDB)
)


private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFB2DFDB),
    onPrimary = Color(0xFF003D33),
    primaryContainer = Color(0xFF00574B),
    onPrimaryContainer = Color(0xFFB2DFDB),
    secondary = Color(0xFFFFB74D),
    onSecondary = Color(0xFF3E2723),
    secondaryContainer = Color(0xFF8D6E63),
    onSecondaryContainer = Color(0xFFFFCC80),
    tertiary = Color(0xFFFFF176),
    onTertiary = Color(0xFF333000),
    tertiaryContainer = Color(0xFF4A4635),
    onTertiaryContainer = Color(0xFFFFF59D),
    error = Color(0xFFCF6679),
    errorContainer = Color(0xFFB00020),
    onError = Color.Black,
    onErrorContainer = Color(0xFFFCD8DF),
    background = Color(0xFF121212),
    onBackground = Color(0xFFE6E1E5),
    surface = Color(0xFF1D1B20),
    onSurface = Color(0xFFE6E1E5),
    surfaceVariant = Color(0xFF49454F),
    onSurfaceVariant = Color(0xFFCAC4D0),
    outline = Color(0xFF938F99),
    inverseOnSurface = Color(0xFF313033),
    inverseSurface = Color(0xFFE6E1E5),
    inversePrimary = ChileanGreen
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
    val CaloriesColor = Color(0xFFFF6B6B)
    val ProteinsColor = Color(0xFF4ECDC4)
    val DifficultyEasy = Color(0xFF66BB6A)
    val DifficultyMedium = Color(0xFFFFB74D)
    val DifficultyHard = Color(0xFFE57373)
    val CardBackground = Color(0xFFFAFAFA)
    val DividerColor = Color(0xFFE0E0E0)
    val BreakfastColor = Color(0xFFFFF9C4)
    val LunchColor = Color(0xFFB2EBF2)
    val SnackColor = Color(0xFFFFECB3)
    val DinnerColor = Color(0xFFD1C4E9)
}