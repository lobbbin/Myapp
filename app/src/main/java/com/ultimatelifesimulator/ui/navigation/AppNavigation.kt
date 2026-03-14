package com.ultimatelifesimulator.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ultimatelifesimulator.ui.screens.character.CharacterScreen
import com.ultimatelifesimulator.ui.screens.main.MainScreen
import com.ultimatelifesimulator.ui.screens.relationships.RelationshipsScreen
import com.ultimatelifesimulator.ui.screens.world.WorldScreen

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Main : Screen("main", "Home", Icons.Default.Home)
    object Character : Screen("character", "Character", Icons.Default.Person)
    object World : Screen("world", "World", Icons.Default.Groups)
    object Career : Screen("career", "Career", Icons.Default.Work)
    object Relationships : Screen("relationships", "Relationships", Icons.Default.Groups)
    object Health : Screen("health", "Health", Icons.Default.Person)
    object Inventory : Screen("inventory", "Inventory", Icons.Default.Home)
    object Events : Screen("events", "Events", Icons.Default.Home)
    object Royalty : Screen("royalty", "Royalty", Icons.Default.Home)
    object Politics : Screen("politics", "Politics", Icons.Default.Work)
    object Crime : Screen("crime", "Crime", Icons.Default.Groups)
    object Business : Screen("business", "Business", Icons.Default.Work)
}

val bottomNavItems = listOf(
    Screen.Main,
    Screen.Character,
    Screen.World,
    Screen.Relationships,
    Screen.Career
)

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                
                bottomNavItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.title) },
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Main.route) { MainScreen(navController) }
            composable(Screen.Character.route) { CharacterScreen() }
            composable(Screen.World.route) { WorldScreen() }
            composable(Screen.Relationships.route) { RelationshipsScreen() }
            composable(Screen.Career.route) { com.ultimatelifesimulator.ui.screens.career.CareerScreen() }
        }
    }
}
