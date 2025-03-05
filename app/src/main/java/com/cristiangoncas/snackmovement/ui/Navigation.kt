package com.cristiangoncas.snackmovement.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.ui.screens.exercisedetail.ExerciseDetailScreen
import com.cristiangoncas.snackmovement.ui.screens.exercises.ExercisesScreen
import com.cristiangoncas.snackmovement.ui.screens.home.HomeScreen
import com.cristiangoncas.snackmovement.ui.screens.statistics.StatisticsScreen
import com.cristiangoncas.snackmovement.ui.screens.DrawerRoute
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val drawerRoutes = listOf(
        DrawerRoute.Goals,
        DrawerRoute.Profile,
        DrawerRoute.Settings,
    )

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
            name = stringResource(R.string.title_statistics),
            route = Statistics,
            icon = painterResource(R.drawable.ic_dashboard_black_24dp),
        )
    )


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                topLevelRoutes.forEach { topLevelRoute ->
                    DrawerItem(title = topLevelRoute.name) {
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(topLevelRoute.route)
                    }
                }
                drawerRoutes.forEach { drawerRoute ->
                    DrawerItem(title = drawerRoute.name) {
                        scope.launch {
                            drawerState.close()
                        }
                        navController.navigate(drawerRoute.route)
                    }
                }
            }
        },
        gesturesEnabled = true
    ){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(R.string.app_name)) },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Open Drawer")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    ),
                )
            },
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
                composable<Statistics> {
                    StatisticsScreen()
                }
            }
        }
    }

}

@Composable
fun DrawerItem(title: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Text(text = title, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider()
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
object Statistics

