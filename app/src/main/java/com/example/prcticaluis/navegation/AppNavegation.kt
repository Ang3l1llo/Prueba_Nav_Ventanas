package com.example.prcticaluis.navegation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.prcticaluis.screens.FirstScreen
import com.example.prcticaluis.screens.SecondScreen


//Función que controla el manejo de ventanas mediangte el navController
@Composable
fun AppNavigation(innerPadding: PaddingValues) {
    val navController = rememberNavController()

    //Empieza en esta ventana(que sería firstscreen)
    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen") {
            FirstScreen(navController)
        }

        //Cuando pulse el botón creado, se manejaría la segunda ventana(secondScxreen)
        composable(
            "secondScreen/{nombre}/{edad}/{email}/{telefono}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("edad") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType },
                navArgument("telefono") { type = NavType.StringType }
            )
        )
        //Mediante el uso del backstackentry podemos acceder a los argumentos o parámetros pasados desde la primera pantalla
        { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre")
            val edad = backStackEntry.arguments?.getString("edad")
            val email = backStackEntry.arguments?.getString("email")
            val telefono = backStackEntry.arguments?.getString("telefono")
            SecondScreen(navController, nombre, edad, email, telefono)
        }
    }
}