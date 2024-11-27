package com.example.prcticaluis.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prcticaluis.ui.theme.BlueBonito

@Composable
fun SecondScreen(navController: NavController, nombre: String?, edad: String?, email: String?, telefono: String?) {
    //Columna para organizar dentro los componentes
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Datos del registro",
            fontWeight = FontWeight.Bold,
            color = BlueBonito,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Mostrar los datos enviados desde la primera pantalla
        if (!nombre.isNullOrEmpty() && !edad.isNullOrEmpty() && !email.isNullOrEmpty() && !telefono.isNullOrEmpty()) {
            Text("Nombre: $nombre")
            Text("Edad: $edad")
            Text("Email: $email")
            Text("Teléfono: $telefono")
        } else {
            Text("No hay datos recibidos")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para volver a la primera pantalla
        Button(onClick = { navController.popBackStack() },
            colors = ButtonDefaults.buttonColors(BlueBonito)) {
            Text("Volver a la pantalla principal")
        }
    }
}