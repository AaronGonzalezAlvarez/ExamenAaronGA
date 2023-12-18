package com.example.examenaaronga

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examenaaronga.screans.Pantalla1
import com.example.examenaaronga.screans.Pantalla2

@Composable
fun AppNav(navController: NavHostController = rememberNavController()){
    NavHost(
        navController = navController,
        startDestination = Routes.Pantalla1.route
    ){
        composable (route = Routes.Pantalla1.route){
            Pantalla1(navController)
        }
        composable (route = Routes.Pantalla2.route){
            Pantalla2(navController)
        }
    }
}