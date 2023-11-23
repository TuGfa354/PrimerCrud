package com.example.primercrud.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Modify(navigationController: NavController, modifier: Modifier = Modifier) {
    var id by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    val fieldBusqueda = "id"
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
                text = "Modifica un producto",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
        }


        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "ID", style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = id,
            onValueChange = { id = it },
            placeholder = { Text(text = "ID...") },
        )
        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Nombre", style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            placeholder = { Text(text = "Nombre...") },
        )
        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Apellidos", style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = surname,
            onValueChange = { surname = it },
            placeholder = { Text(text = "Apellidos...") },
        )
        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Teléfono", style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            placeholder = { Text(text = "Teléfono...") },
        )
        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "Correo", style = MaterialTheme.typography.bodyLarge
        )

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { email = it },
            placeholder = { Text(text = "Correo...") },
        )
        Spacer(modifier = Modifier.padding(8.dp))
        val dato = hashMapOf(
            "id" to id.toString(),
            "name" to name.toString(),
            "surname" to surname.toString(),
            "phoneNumber" to phoneNumber.toString(),
            "email" to email.toString()
        )
        var datos by remember { mutableStateOf("") }
        var mensaje_confirmacion by remember { mutableStateOf("") }
        Button(onClick = {
            if (id.isNotBlank()) {


                db.collection(nombre_coleccion).whereEqualTo(fieldBusqueda, id).get()
                    .addOnSuccessListener { resultado ->
                        for (encontrado in resultado) {
                            datos += "${encontrado.id}: ${encontrado.data}\n"

                            name += encontrado["name"].toString()
                            surname += encontrado["surname"].toString()
                            phoneNumber += encontrado["phoneNumber"].toString()
                            email += encontrado["email"].toString()


                        }
                        if (datos.isEmpty()) {
                            mensaje_confirmacion = "No existen datos"
                        } else {
                            if (validacionDNI(id) && validacionNombre(name) && validacionApellido(
                                    surname
                                ) && validacionTelefono(phoneNumber) && validacionCorreo(email)
                            ) {
                                db.collection(nombre_coleccion).document(id).set(dato)
                                mensaje_confirmacion =
                                    "Se ha modificado correctamente el cliente con el id : " + id
                            } else {
                                mensaje_confirmacion = "Datos inválidos"
                            }
                        }
                        datos = ""
                        id = ""
                        name = ""
                        surname = ""
                        phoneNumber = ""
                        email = ""

                    }.addOnFailureListener {

                        mensaje_confirmacion = "La conexión ha fallado"

                        datos = ""
                        id = ""
                        name = ""
                        surname = ""
                        phoneNumber = ""
                        email = ""
                    }

            }

        },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .width(120.dp),
            shape = RectangleShape,
            contentPadding = PaddingValues(8.dp),
            content = {
                Text(
                    text = "Enviar"
                )
            })
        Text(text = mensaje_confirmacion)
    }
}
