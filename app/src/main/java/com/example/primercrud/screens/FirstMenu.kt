package com.example.primercrud.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun FirstMenu(navigationController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


        ) {
        Button(onClick = { navigationController.navigate("ProductsMenu") },
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            content = {
                Text(
                    text = "Gestionar productos", modifier = modifier.align(Alignment.CenterVertically)


                )
            })
        Spacer(modifier = Modifier.padding(8.dp))

        Button(onClick = { navigationController.navigate("MainMenu") },
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            content = {
                Text(
                    text = "Gestionar clientes"
                )
            })


    }
}