package com.example.primercrud.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.primercrud.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstMenu(navigationController: NavController, modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableStateOf(0) }


        // Content of your screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Text(
                text = "My App de CRM",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(16.dp)
            )

            // Subtitle
            Text(
                text = "Bienvenido al menú principal. Elige una de las opciones:",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(8.dp)
            )

            // Divider
            Divider(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp), color = Color.Gray)

            // Menu Buttons
            MenuButton(
                onClick = { navigationController.navigate("ProductsMenu") },
                text = "Gestionar productos",
                icon = Icons.Default.ShoppingCart
            )

            MenuButton(
                onClick = { navigationController.navigate("MainMenu") },
                text = "Gestionar clientes",
                icon = Icons.Default.Person
            )
        }

}

@Composable
fun MenuButton(onClick: () -> Unit, text: String, icon: ImageVector) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .shadow(4.dp, shape = CircleShape)
            .clip(CircleShape)
            .background(Color.Blue),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.textButtonColors(contentColor = Color.Black),
        content = {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = text)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Outlined.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        shape = MaterialTheme.shapes.medium
    )
}
