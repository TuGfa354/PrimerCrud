package com.example.primercrud.navigation

sealed class AppScreens(val path: String) {

    object  MainMenu: AppScreens("MainMenu")
    object Save: AppScreens("Save")
    object Read: AppScreens("Read")
    object Modify: AppScreens("Modify")
    object Delete: AppScreens("Delete")
    object List: AppScreens("List")
}