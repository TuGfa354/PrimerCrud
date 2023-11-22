package com.example.primercrud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.primercrud.screens.*

@Composable
fun AppNavigation(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.FirstMenu.path)
    {
        composable(AppScreens.FirstMenu.path) { FirstMenu(navigationController) }
        composable(AppScreens.MainMenu.path) { MainMenu(navigationController) }
        composable(AppScreens.ProductsMenu.path) { ProductsMenu(navigationController) }
        composable(AppScreens.Save.path) { Save(navigationController) }
        composable(AppScreens.SaveProduct.path) { SaveProduct(navigationController) }
        composable(AppScreens.Read.path) { Read(navigationController) }
        composable(AppScreens.ReadProduct.path) { ReadProduct(navigationController) }
        composable(AppScreens.Modify.path) { Modify(navigationController) }
        composable(AppScreens.ModifyProduct.path) { ModifyProduct(navigationController) }
        composable(AppScreens.Delete.path) { Delete(navigationController) }
        composable(AppScreens.DeleteProduct.path) { DeleteProduct(navigationController) }
        composable(AppScreens.List.path) { List(navigationController) }
        composable(AppScreens.ListProduct.path) { ListProduct(navigationController) }
    }
}