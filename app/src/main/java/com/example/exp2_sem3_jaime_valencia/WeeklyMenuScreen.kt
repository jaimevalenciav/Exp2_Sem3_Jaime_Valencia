// Archivo: WeeklyMenuScreen.kt
package com.example.exp2_sem3_jaime_valencia

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeeklyMenuScreen(
    navController: NavController
) {
    val repository = remember { RecipeRepository() }
    var weeklyMenu by remember { mutableStateOf(repository.generateWeeklyMenu()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        WeeklyMenuTopBar(
            onBackClick = { navController.popBackStack() },
            onRefreshClick = {
                weeklyMenu = repository.generateWeeklyMenu()
            }
        )


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(weeklyMenu) { dailyMenu ->
                DailyMenuCard(
                    dailyMenu = dailyMenu,
                    onRecipeClick = { recipeId ->
                        navController.navigate(Routes.recipeDetail(recipeId))
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WeeklyMenuTopBar(
    onBackClick: () -> Unit,
    onRefreshClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Minuta Semanal",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver"
                )
            }
        },
        actions = {
            IconButton(onClick = onRefreshClick) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Generar nuevo menú",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    )
}

@Composable
private fun DailyMenuCard(
    dailyMenu: DailyMenu,
    onRecipeClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dailyMenu.dayOfWeek.displayName,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                )


                val completedMeals = listOf(
                    dailyMenu.breakFast, dailyMenu.lunch,
                    dailyMenu.dinner, dailyMenu.snack
                ).count { it != null }

                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(
                            if (completedMeals == 4) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "$completedMeals/4",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = if (completedMeals == 4)
                                MaterialTheme.colorScheme.onPrimary
                            else MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    MealCard(
                        modifier = Modifier.weight(1f),
                        meal = dailyMenu.breakFast,
                        mealType = "Desayuno",
                        icon = Icons.Default.Face,
                        backgroundColor = AppColors.BreakfastColor,
                        onRecipeClick = onRecipeClick
                    )

                    MealCard(
                        modifier = Modifier.weight(1f),
                        meal = dailyMenu.lunch,
                        mealType = "Almuerzo",
                        icon = Icons.Default.Home,
                        backgroundColor = AppColors.LunchColor,
                        onRecipeClick = onRecipeClick
                    )
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    MealCard(
                        modifier = Modifier.weight(1f),
                        meal = dailyMenu.snack,
                        mealType = "Once",
                        icon = Icons.Default.Face,
                        backgroundColor = AppColors.SnackColor,
                        onRecipeClick = onRecipeClick
                    )

                    MealCard(
                        modifier = Modifier.weight(1f),
                        meal = dailyMenu.dinner,
                        mealType = "Cena",
                        icon = Icons.Default.Place,
                        backgroundColor = AppColors.DinnerColor,
                        onRecipeClick = onRecipeClick
                    )
                }
            }
        }
    }
}

@Composable
private fun MealCard(
    modifier: Modifier = Modifier,
    meal: Recipe?,
    mealType: String,
    icon: ImageVector,
    backgroundColor: Color,
    onRecipeClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .height(100.dp)
            .clickable {
                meal?.let { onRecipeClick(it.id) }
            },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = mealType,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                    )
                }


                if (meal != null) {
                    Text(
                        text = meal.nombre,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start
                    )
                } else {
                    Text(
                        text = "Sin asignar",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                            fontWeight = FontWeight.Light
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }


            meal?.let {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(
                            when (it.dificultad) {
                                Difficulty.EASY -> AppColors.DifficultyEasy
                                Difficulty.MEDIUM -> AppColors.DifficultyMedium
                                Difficulty.HARD -> AppColors.DifficultyHard
                            }
                        )
                )
            }
        }
    }
}