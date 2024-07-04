package com.example.marvel.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.marvel.screens.HeroScreen
import com.example.marvel.screens.MainScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object HeroScreen : Screens("hero_screen/{heroName}/{heroImageUrl}/{heroDescription}") {
        fun createRoute(heroName: String, heroImageUrl: String, heroDescription: String): String {
            val encodedHeroName = URLEncoder.encode(heroName, StandardCharsets.UTF_8.toString())
            val encodedHeroImageUrl = URLEncoder.encode(heroImageUrl, StandardCharsets.UTF_8.toString())
            val encodedHeroDescription = URLEncoder.encode(heroDescription, StandardCharsets.UTF_8.toString())
            return "hero_screen/$encodedHeroName/$encodedHeroImageUrl/$encodedHeroDescription"
        }

        val arguments: List<NamedNavArgument> = listOf(
            navArgument("heroName") { type = NavType.StringType },
            navArgument("heroImageUrl") { type = NavType.StringType },
            navArgument("heroDescription") { type = NavType.StringType }
        )
    }
}

@Composable
fun SetupNavHost(startDestination: String = Screens.MainScreen.route) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screens.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screens.HeroScreen.route,
            arguments = Screens.HeroScreen.arguments
        ) { backStackEntry ->
            HeroScreen(navController = navController, navBackStackEntry = backStackEntry)
        }
    }
}
