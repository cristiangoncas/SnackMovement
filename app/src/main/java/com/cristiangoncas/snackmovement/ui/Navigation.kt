package com.cristiangoncas.snackmovement.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.ui.screens.profile.ProfileScreen
import com.cristiangoncas.snackmovement.ui.screens.dashboard.DashboardScreen
import com.cristiangoncas.snackmovement.ui.screens.exercisedetail.ExerciseDetailScreen
import com.cristiangoncas.snackmovement.ui.screens.exercises.ExercisesScreen
import com.cristiangoncas.snackmovement.ui.screens.home.HomeScreen
import com.cristiangoncas.snackmovement.ui.screens.notifications.NotificationsScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val topLevelRoutes = listOf(
        TopLevelRoute(
            name = stringResource(R.string.title_home),
            route = Home,
            icon = painterResource(R.drawable.ic_home_black_24dp),
        ),
        TopLevelRoute(
            name = stringResource(R.string.title_exercises),
            route = Exercises,
            icon = painterResource(R.drawable.ic_notifications_black_24dp),
        ),
        TopLevelRoute(
            name = stringResource(R.string.title_dashboard),
            route = Dashboard,
            icon = painterResource(R.drawable.ic_dashboard_black_24dp),
        ),
        TopLevelRoute(
            name = stringResource(R.string.title_notifications),
            route = Notifications,
            icon = painterResource(R.drawable.ic_notifications_black_24dp),
        ),
        TopLevelRoute(
            name = stringResource(R.string.title_profile),
            route = Profile,
            icon = painterResource(R.drawable.ic_notifications_black_24dp),
        ),
    )

    Scaffold(
        bottomBar = {
            val navBackStackEntry = navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry.value?.destination

            if (currentDestination?.route != "${ExerciseDetail}/{exerciseId}") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    topLevelRoutes.forEach { topLevelRoute ->
                        BottomNavigationItem(
                            icon = topLevelRoute.icon,
                            name = topLevelRoute.name,
                            selected = currentDestination?.route?.let {
                                topLevelRoute.route.toString().contains(it)
                            } == true,
                            onClick = {
                                navController.navigate(topLevelRoute.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(padding)
        ) {
            composable<Home> {
                HomeScreen()
            }
            composable<Exercises> {
                ExercisesScreen(viewModel()) { exerciseId ->
                    navController.navigate("${ExerciseDetail}/$exerciseId")
                }
            }
            composable(
                route = "${ExerciseDetail}/{exerciseId}",
                arguments = listOf(navArgument("exerciseId") { type = NavType.IntType })
            ) { backStackEntry ->
                val exerciseId = backStackEntry.arguments?.getInt("exerciseId")
                exerciseId?.let {
                    ExerciseDetailScreen(exerciseId = it)
                }

            }
            composable<Dashboard> {
                DashboardScreen()
            }
            composable<Notifications> {
                NotificationsScreen()
            }
            composable<Profile> {
                ProfileScreen()
            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    name: String,
    icon: Painter,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable(
                onClick = onClick,
                role = Role.Tab,
            )
            .padding(top = 8.dp, bottom = 16.dp, start = 4.dp, end = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
    ) {
        Icon(
            painter = icon,
            contentDescription = name,
            tint = if (selected) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = if (selected) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurface,
        )
    }
}

private data class TopLevelRoute<T : Any>(val name: String, val route: T, val icon: Painter)

@Serializable
object Home

@Serializable
object Exercises

@Serializable
object ExerciseDetail

@Serializable
object Dashboard

@Serializable
object Notifications

@Serializable
object Profile
