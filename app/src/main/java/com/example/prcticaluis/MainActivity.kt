package com.example.prcticaluis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prcticaluis.navegation.AppNavigation
import com.example.prcticaluis.ui.theme.PrácticaLuisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrácticaLuisTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(innerPadding)
                }
            }
        }
    }
}

//Para previsualizar el proyecto, aunque solo estético por que para funcionalidad no sirve
@Preview(showBackground = true)
@Composable
fun AppNavegationPreview() {
    PrácticaLuisTheme {
        AppNavigation(innerPadding = PaddingValues(16.dp))
    }
}