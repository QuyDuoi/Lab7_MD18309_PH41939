package com.quyduoi.lab7_md18309_ph41939.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.quyduoi.lab7_md18309_ph41939.ViewModel.MovieViewModel

enum class Screen(val route: String) {
    LOGIN("Login"),
    MOVIE_SCREEN("MovieScreen"),
    ADD("Add"),
    EDIT("Edit"),
}

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    val movieViewModel = MovieViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.LOGIN.route,
    ) {
        composable(Screen.LOGIN.route) { LoginScreen(navController) }
        composable(Screen.MOVIE_SCREEN.route) { MovieScreen(navController, movieViewModel) }
        composable(Screen.ADD.route) { MovieFormScreen(navController, movieViewModel, null) }
        composable(
            "${Screen.EDIT.route}/{filmId}",
            arguments = listOf(navArgument("filmId") { type = NavType.StringType }),
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("filmId")?.let { filmId ->
                MovieFormScreen(navController, movieViewModel, filmId)
            }
        }
    }
}