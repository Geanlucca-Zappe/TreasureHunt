package com.example.treasurehunt.navigation

import androidx.compose.runtime.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.example.treasurehunt.screens.*

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val startTime = remember { mutableStateOf(0L) }

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onStart = {
                startTime.value = System.currentTimeMillis()
                navController.navigate("clue1")
            })
        }
        composable("clue1") {
            ClueScreen(
                clue = "Sou redondo e marco o tempo. O que sou?",
                answer = "relógio",
                onCorrect = { navController.navigate("clue2") },
                onBack = { navController.popBackStack() }
            )
        }
        composable("clue2") {
            ClueScreen(
                clue = "Tenho chaves mas não tranco portas. O que sou?",
                answer = "teclado",
                onCorrect = { navController.navigate("clue3") },
                onBack = { navController.popBackStack() }
            )
        }
        composable("clue3") {
            ClueScreen(
                clue = "Subo mas nunca desço. O que sou?",
                answer = "idade",
                onCorrect = {
                    val totalTime = (System.currentTimeMillis() - startTime.value) / 1000
                    navController.navigate("treasure/$totalTime")
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable(
            "treasure/{time}",
            arguments = listOf(navArgument("time") { type = NavType.LongType })
        ) { backStackEntry ->
            val time = backStackEntry.arguments?.getLong("time") ?: 0L
            TreasureScreen(
                timeTaken = time,
                onRestart = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            )
        }
    }
}
