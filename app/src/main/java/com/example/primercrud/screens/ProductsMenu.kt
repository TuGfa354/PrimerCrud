package com.example.primercrud.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProductsMenu(navigationController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .clickable { navigationController.popBackStack() }
                    .padding(8.dp)
            )

            Text(
                text = "Gestión de productos",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(start = 8.dp).fillMaxWidth(),
                fontSize = 24.sp
            )
        }

        // Product Management Buttons
        MenuButton(
            onClick = { navigationController.navigate("SaveProduct") },
            text = "Guardar",
            icon = Icons.Default.Add
        )
        Spacer(modifier = Modifier.padding(8.dp))

        MenuButton(
            onClick = { navigationController.navigate("ModifyProduct") },
            text = "Modificar",
            icon = Icons.Default.Create
        )
        Spacer(modifier = Modifier.padding(8.dp))

        MenuButton(
            onClick = { navigationController.navigate("DeleteProduct") },
            text = "Eliminar",
            icon = Icons.Default.Delete
        )
        Spacer(modifier = Modifier.padding(8.dp))

        MenuButton(
            onClick = { navigationController.navigate("ReadProduct") },
            text = "Buscar",
            icon = Icons.Default.Search
        )
        Spacer(modifier = Modifier.padding(8.dp))

        MenuButton(
            onClick = { navigationController.navigate("ListProduct") },
            text = "Listar",
            icon = Icons.Default.List
        )
        Spacer(modifier = Modifier.padding(8.dp))
    }
}
