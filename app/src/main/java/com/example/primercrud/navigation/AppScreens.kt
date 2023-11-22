package com.example.primercrud.navigation

sealed class AppScreens(val path: String) {

    object  FirstMenu: AppScreens("FirstMenu")
    object  MainMenu: AppScreens("MainMenu")
    object  ProductsMenu: AppScreens("ProductsMenu")
    object Save: AppScreens("Save")
    object SaveProduct: AppScreens("SaveProduct")
    object Read: AppScreens("Read")
    object ReadProduct: AppScreens("ReadProduct")
    object Modify: AppScreens("Modify")
    object ModifyProduct: AppScreens("ModifyProduct")
    object Delete: AppScreens("Delete")
    object DeleteProduct: AppScreens("DeleteProduct")
    object List: AppScreens("List")
    object ListProduct: AppScreens("ListProduct")
}