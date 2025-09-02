package com.example.exp2_sem3_jaime_valencia

data class Recipe(
    val id: Int = 0,
    val nombre: String = "",
    val descripcion: String = "",
    val ingredientes: List<String> = emptyList(),
    val tiempoPreparacion: Int = 0,
    val calorias: Int = 0,
    val proteinas: Double = 0.0,
    val imagen: Int = 0,
    val dificultad: Difficulty = Difficulty.EASY,
    val categoria: Category = Category.BREAKFAST
)

enum class Difficulty(val displayName: String) {
    EASY("Fácil"),
    MEDIUM("Intermedio"),
    HARD("Difícil")
}

enum class Category(val displayName: String) {
    BREAKFAST("Desayuno"),
    LUNCH("Almuerzo"),
    DINNER("Cena"),
    SNACK("Once")
}

data class DailyMenu(
    val dayOfWeek: DayOfWeek,
    val breakFast: Recipe?,
    val lunch: Recipe?,
    val dinner: Recipe?,
    val snack: Recipe?
)

enum class DayOfWeek(val displayName: String) {
    MONDAY("Lunes"),
    TUESDAY("Martes"),
    WEDNESDAY("Miércoles"),
    THURSDAY("Jueves"),
    FRIDAY("Viernes"),
    SATURDAY("Sábado"),
    SUNDAY("Domingo")
}

data class NutritionalInfo(
    val totalCalorias: Int = 0,
    val totalProteinas: Double = 0.0,
    val averageCaloriasPerDay: Double = 0.0,
    val averageProteinasPerDay: Double = 0.0
)