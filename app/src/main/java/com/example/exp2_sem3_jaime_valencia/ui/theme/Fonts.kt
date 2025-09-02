package com.example.exp2_sem3_jaime_valencia.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.exp2_sem3_jaime_valencia.R

// Familia de fuentes principal (Poppins)
// Asegúrate de que los archivos de las fuentes se llamen:
// poppins_regular.ttf, poppins_medium.ttf, poppins_bold.ttf
val CustomFontFamily = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

// Familia de fuentes para títulos (Nunito)
// Asegúrate de que los archivos de las fuentes se llamen:
// nunito_semibold.ttf, nunito_bold.ttf
val TitleFontFamily = FontFamily(
    Font(R.font.nunito_semibold, FontWeight.SemiBold),
    Font(R.font.nunito_bold, FontWeight.Bold)
)