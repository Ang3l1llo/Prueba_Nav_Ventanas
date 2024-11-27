package com.example.prcticaluis.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prcticaluis.ui.theme.BlueBonito


@Composable
fun FirstScreen(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }

    // Obtener el contexto para usarlo abajo en el toast, que me daba problemas si no lo creaba como variable
    val context = LocalContext.current

    //Primero creo una columna para organizar dentro componentes
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Mensaje de bienvenida de buenro
        Text(
            text = "Bienvenido al registro de Don Luis",
            fontWeight = FontWeight.Bold,
            color = BlueBonito,
            fontSize = 23.sp,
            modifier = Modifier.padding(bottom = 16.dp),
            )

        // Campo para el nombre
        TextField(
            value = nombre,
            onValueChange = { newNombre ->
                // Mediante esta condición obligo al usuario a solo poner letras
                if (newNombre.all { it.isLetter() || it.isWhitespace() }) {
                    nombre = newNombre
                }
            },
            label = { Text("Nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Campo para la edad
        TextField(
            value = edad,
            onValueChange = { newEdad ->
                // Con este hago lo contrario, solo permito números
                if (newEdad.all { it.isDigit() }) {
                    edad = newEdad
                }
            },
            label = { Text("Edad") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        //Campo para el email
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        //Campo para el teléfono
        TextField(
            value = telefono,
            onValueChange = { newTelefono ->
                // Con este hago lo mismo que para la edad, solo que añadiendo que tenga una longitud máxima como pediste
                if (newTelefono.all { it.isDigit() && newTelefono.length <= 9}) {
                    telefono = newTelefono
                }
            },
            label = { Text("Teléfono") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Botón para navegar a la segunda pantalla
        Button(onClick = {
            // Con esto se verifica que los campos no estén vacíos antes de enviar los datos
            if (nombre.isNotEmpty() && edad.isNotEmpty() && email.isNotEmpty() && telefono.isNotEmpty()) {
                navController.navigate("secondScreen/$nombre/$edad/$email/$telefono")
            } else {
                // Mostrar el mensaje de error utilizando Toast que mencioné arriba, te manda un mensaje sutil y presioso
                Toast.makeText(context, "Por favor, ingresa todos los datos", Toast.LENGTH_SHORT).show()
            }
        },
            colors = ButtonDefaults.buttonColors(BlueBonito)
            ) {

            Text("Enviar Datos")
        }
    }
}