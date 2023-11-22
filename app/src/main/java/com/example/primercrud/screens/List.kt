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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun List(navigationController: NavController, modifier: Modifier = Modifier) {
    var nombre_coleccion = "Clientes"
    val db = FirebaseFirestore.getInstance()
    Column(
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .clickable { navigationController.popBackStack() }//Vuelve hacia la última pantalla
                    .padding(8.dp)
            )

            Text(
                text = "Listado de clientes",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))


        var mensaje_confirmacion by remember { mutableStateOf("") }
        var datos by remember { mutableStateOf("") }
        Button(onClick = {

                datos =""
                db.collection(nombre_coleccion).get()
                    .addOnSuccessListener { resultado ->
                        for (encontrado in resultado){
                            datos+="${encontrado.id}: ${encontrado.data}\n"
                            datos += "\n" // Add a newline to separate documents

                        }
                        if (datos.isEmpty()){
                            mensaje_confirmacion = "No existen datos"
                        }


                    }.addOnFailureListener {

                        mensaje_confirmacion = "La conexión ha fallado"

                    }




        },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .width(120.dp),
            shape = RectangleShape,
            contentPadding = PaddingValues(8.dp),
            content = {
                Text(
                    text = "Cargar datos"
                )
            })
        Text(text = mensaje_confirmacion)
        Text(text = datos)


    }
}