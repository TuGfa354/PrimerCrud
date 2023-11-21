package com.example.primercrud.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Horizontal
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.primercrud.ui.theme.PrimerCrudTheme

@Composable
fun MainMenu(navigationController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


        ) {
        Button(
            onClick = { navigationController.navigate("Save") },
            modifier = modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            content = {
                Text(
                    text = "Guardar",
                    modifier = modifier
                        .align(Alignment.CenterVertically)


                )
            }
        )
        Button(
            onClick = { navigationController.navigate("Modify") },
            modifier = modifier,
            contentPadding = PaddingValues(16.dp),
            content = {
                Text(
                    text = "Modificar"
                )
            }
        )
        Button(
            onClick = { navigationController.navigate("Delete") },
            modifier = modifier,
            contentPadding = PaddingValues(16.dp),
            content = {
                Text(
                    text = "Eliminar"
                )
            }
        )
        Button(
            onClick = { navigationController.navigate("Read") },
            modifier = modifier,
            contentPadding = PaddingValues(16.dp),
            content = {
                Text(
                    text = "Buscar"
                )
            }
        )
        Button(
            onClick = { navigationController.navigate("List") },
            modifier = modifier,
            contentPadding = PaddingValues(16.dp),
            content = {
                Text(
                    text = "Listar"
                )
            }
        )
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    PrimerCrudTheme {
//       MainMenu(navigationController: NavController, modifier = Modifier)
//    }
//}

