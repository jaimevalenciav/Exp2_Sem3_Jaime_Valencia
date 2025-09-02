package com.example.exp2_sem3_jaime_valencia


/**
 * Objeto que centraliza todas las rutas de navegación
 */
object Routes {
    const val SPLASH = "splash"
    const val HOME = "home"
    const val WEEKLY_MENU = "weekly_menu"
    const val RECIPE_DETAIL = "recipe_detail/{recipeId}"


    fun recipeDetail(recipeId: Int): String = "recipe_detail/$recipeId"
}