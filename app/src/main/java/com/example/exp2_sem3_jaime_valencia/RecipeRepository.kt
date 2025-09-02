package com.example.exp2_sem3_jaime_valencia

// Archivo: repository/RecipeRepository.kt
import android.content.Context

class RecipeRepository {

    // Array de recetas chilenas típicas
    private val recipes = arrayOf(
        Recipe(
            id = 1,
            nombre = "Empanadas de Pino",
            descripcion = "Tradicional empanada chilena rellena de carne, cebolla, huevo y aceitunas",
            ingredientes = listOf(
                "500g harina", "200g manteca", "300g pino de vacuno",
                "2 cebollas", "2 huevos duros", "aceitunas negras", "comino", "ají de color"
            ),
            tiempoPreparacion = 45,
            calorias = 320,
            proteinas = 15.5,
            imagen = R.drawable.empanadas, // Necesitarás agregar esta imagen
            dificultad = Difficulty.MEDIUM,
            categoria = Category.LUNCH
        ),
        Recipe(
            id = 2,
            nombre = "Cazuela de Pollo",
            descripcion = "Sopa tradicional chilena con pollo, verduras y choclo",
            ingredientes = listOf(
                "1 pollo trozado", "2 papas", "1 zapallo", "1 choclo",
                "1 zanahoria", "porotos verdes", "arroz", "cilantro"
            ),
            tiempoPreparacion = 60,
            calorias = 280,
            proteinas = 22.0,
            imagen = R.drawable.cazuela,
            dificultad = Difficulty.EASY,
            categoria = Category.LUNCH
        ),
        Recipe(
            id = 3,
            nombre = "Sopaipillas",
            descripcion = "Masa frita tradicional, perfecta para acompañar el té",
            ingredientes = listOf(
                "500g harina", "100g zapallo cocido", "1 cdta polvos de hornear",
                "sal", "aceite para freír", "chancaca o miel"
            ),
            tiempoPreparacion = 30,
            calorias = 180,
            proteinas = 4.2,
            imagen = R.drawable.sopaipillas,
            dificultad = Difficulty.EASY,
            categoria = Category.SNACK
        ),
        Recipe(
            id = 4,
            nombre = "Pastel de Choclo",
            descripcion = "Tradicional pastel chileno con base de carne y cobertura de choclo",
            ingredientes = listOf(
                "6 choclos", "500g pino de vacuno", "4 presas de pollo",
                "huevos duros", "aceitunas", "azúcar", "albahaca"
            ),
            tiempoPreparacion = 90,
            calorias = 350,
            proteinas = 18.0,
            imagen = R.drawable.pastel_choclo,
            dificultad = Difficulty.HARD,
            categoria = Category.DINNER
        ),
        Recipe(
            id = 5,
            nombre = "Completo Italiano",
            descripcion = "Hot dog chileno con palta, tomate y mayonesa",
            ingredientes = listOf(
                "4 vienesas", "4 panes de completo", "2 paltas maduras",
                "3 tomates", "mayonesa casera"
            ),
            tiempoPreparacion = 15,
            calorias = 420,
            proteinas = 16.8,
            imagen = R.drawable.completo,
            dificultad = Difficulty.EASY,
            categoria = Category.LUNCH
        ),
        Recipe(
            id = 6,
            nombre = "Leche con Plátano",
            descripcion = "Desayuno tradicional chileno nutritivo y energético",
            ingredientes = listOf(
                "1 taza leche", "1 plátano maduro", "1 cdta azúcar",
                "canela en polvo", "avena (opcional)"
            ),
            tiempoPreparacion = 5,
            calorias = 180,
            proteinas = 8.5,
            imagen = R.drawable.leche_platano,
            dificultad = Difficulty.EASY,
            categoria = Category.BREAKFAST
        ),
        Recipe(
            id = 7,
            nombre = "Charquicán",
            descripcion = "Guiso tradicional con papas, zapallo y charqui o carne",
            ingredientes = listOf(
                "500g papas", "300g zapallo", "200g charqui o carne",
                "1 cebolla", "1 zanahoria", "choclo", "ají de color"
            ),
            tiempoPreparacion = 40,
            calorias = 290,
            proteinas = 20.5,
            imagen = R.drawable.charquican,
            dificultad = Difficulty.MEDIUM,
            categoria = Category.LUNCH
        )
    )

    // Función para obtener todas las recetas
    fun getAllRecipes(): Array<Recipe> {
        return recipes
    }

    // Función para obtener recetas por categoría
    fun getRecipesByCategory(category: Category): List<Recipe> {
        return recipes.filter { it.categoria == category }
    }

    // Función para buscar receta por ID
    fun getRecipeById(id: Int): Recipe? {
        return recipes.find { it.id == id }
    }

    // Función para generar un menú semanal aleatorio
    fun generateWeeklyMenu(): List<DailyMenu> {
        val weeklyMenu = mutableListOf<DailyMenu>()

        // Obtenemos las recetas por categoría para facilitar la asignación
        val breakfastRecipes = getRecipesByCategory(Category.BREAKFAST)
        val lunchRecipes = getRecipesByCategory(Category.LUNCH)
        val dinnerRecipes = getRecipesByCategory(Category.DINNER)
        val snackRecipes = getRecipesByCategory(Category.SNACK)

        // Generamos un menú para cada día de la semana
        DayOfWeek.values().forEach { day ->
            weeklyMenu.add(
                DailyMenu(
                    dayOfWeek = day,
                    breakFast = breakfastRecipes.randomOrNull(),
                    lunch = lunchRecipes.random(),
                    dinner = dinnerRecipes.randomOrNull(),
                    snack = snackRecipes.randomOrNull()
                )
            )
        }

        return weeklyMenu
    }

    // Función para calcular información nutricional de un menú semanal
    fun calculateNutritionalInfo(weeklyMenu: List<DailyMenu>): NutritionalInfo {
        var totalcalorias = 0
        var totalproteinas = 0.0
        var mealsCount = 0

        weeklyMenu.forEach { dailyMenu ->
            listOf(dailyMenu.breakFast, dailyMenu.lunch, dailyMenu.dinner, dailyMenu.snack)
                .filterNotNull()
                .forEach { recipe ->
                    totalcalorias += recipe.calorias
                    totalproteinas += recipe.proteinas
                    mealsCount++
                }
        }

        return NutritionalInfo(
            totalCalorias = totalcalorias,
            totalProteinas = totalproteinas,
            averageCaloriasPerDay = totalcalorias.toDouble() / 7,
            averageProteinasPerDay = totalproteinas / 7
        )
    }
}