package com.example.primercrud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.primercrud.screens.*

@Composable
fun AppNavigation(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.MainMenu.path)
    {
        composable(AppScreens.MainMenu.path) { MainMenu(navigationController) }
        composable(AppScreens.Save.path) { Save(navigationController) }
        composable(AppScreens.Read.path) { Read(navigationController) }
        composable(AppScreens.Modify.path) { Modify(navigationController) }
        composable(AppScreens.Delete.path) { Delete(navigationController) }
        composable(AppScreens.List.path) { List(navigationController) }
    }
}