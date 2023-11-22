package com.example.wazitoecomerce.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecomerce.ui.theme.screens.Home.HomeScreen
import com.example.wazitoecomerce.ui.theme.screens.login.LoginScreen
import com.example.wazitoecomerce.ui.theme.screens.products.AddProductScreen
import com.example.wazitoecomerce.ui.theme.screens.products.ViewProductScreen
import com.example.wazitoecomerce.ui.theme.screens.signup.SignupScreen

@Composable
fun AppNavHost(
    modifier : Modifier = Modifier,
    navController: NavHostController= rememberNavController(),
    startDestination:String= HOME_URL
){
    NavHost(navController = navController
        ,modifier = Modifier
        ,startDestination = startDestination ) {

        composable(HOME_URL) {
            HomeScreen(naveController=navController)
        }
        composable(VIEW_PRODUCTS_URL) {
           ViewProductScreen (naveController =navController)

        }
        composable(ADD_PRODUCTS_URL){
         AddProductScreen(naveController = navController)
    }
        composable(SIGNUP_URL){
           SignupScreen(naveController = navController)
    }
        composable(LOGIN_URL){
            LoginScreen(naveController = navController)
}
    }
}