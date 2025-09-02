// Archivo: navigation/AppNavigation.kt
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exp2_sem3_jaime_valencia.HomeScreen
import com.example.exp2_sem3_jaime_valencia.RecipeDetailScreen
import com.example.exp2_sem3_jaime_valencia.SplashScreen
import com.example.exp2_sem3_jaime_valencia.WeeklyMenuScreen

// Definimos las rutas de navegación como constantes
object Routes {
    const val SPLASH = "splash"
    const val HOME = "home"
    const val WEEKLY_MENU = "weekly_menu"
    const val RECIPE_DETAIL = "recipe_detail/{recipeId}"

    const val NUTRITIONAL_INFO = "nutritional_info"

    fun recipeDetail(recipeId: Int): String {
        return "recipe_detail/$recipeId"
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { 1000 },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -1000 },
                animationSpec = tween(300)
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { 1000 },
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {
        composable(
            route = Routes.SPLASH,
            enterTransition = {
                scaleIn(
                    initialScale = 0.8f,
                    animationSpec = tween(600)
                ) + fadeIn(animationSpec = tween(600))
            }
        ) {
            SplashScreen(navController = navController)
        }

        // Pantalla principal
        composable(Routes.HOME) {
            HomeScreen(navController = navController)
        }

        // Pantalla del menú semanal
        composable(
            route = Routes.WEEKLY_MENU,
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { it },
                    animationSpec = tween(400)
                ) + fadeIn(animationSpec = tween(400))
            },
            exitTransition = {
                slideOutVertically(
                    targetOffsetY = { -it },
                    animationSpec = tween(400)
                ) + fadeOut(animationSpec = tween(400))
            },
            popEnterTransition = {
                slideInVertically(
                    initialOffsetY = { -it },
                    animationSpec = tween(400)
                ) + fadeIn(animationSpec = tween(400))
            },
            popExitTransition = {
                slideOutVertically(
                    targetOffsetY = { it },
                    animationSpec = tween(400)
                ) + fadeOut(animationSpec = tween(400))
            }
        ) {
            WeeklyMenuScreen(navController = navController)
        }

        // Pantalla de detalle de receta
        composable(
            route = Routes.RECIPE_DETAIL,
            enterTransition = {
                slideInVertically(
                    initialOffsetY = { it },
                    animationSpec = tween(500)
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = {
                slideOutVertically(
                    targetOffsetY = { it },
                    animationSpec = tween(500)
                ) + fadeOut(animationSpec = tween(300))
            }
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getString("recipeId")?.toIntOrNull() ?: 0
            RecipeDetailScreen(
                recipeId = recipeId,
                navController = navController
            )
        }



    }
}

// Extensión para navegación más simple
fun NavHostController.navigateToRecipeDetail(recipeId: Int) {
    navigate(Routes.recipeDetail(recipeId))
}

// Extensión para navegación con limpieza de back stack
fun NavHostController.navigateAndClearStack(route: String) {
    navigate(route) {
        popUpTo(graph.startDestinationId) {
            inclusive = true
        }
    }
}
