package com.example.wazitoecomerce.ui.theme.screens.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecomerce.navigation.VIEW_PRODUCTS_URL
import com.example.wazitoecomerce.navigation.LOGIN_URL
import com.example.wazitoecomerce.navigation.ADD_PRODUCTS_URL
import com.example.wazitoecomerce.navigation.SIGNUP_URL
import com.example.wazitoecomerce.ui.theme.WazitoEComerceTheme



@Composable
fun HomeScreen(naveController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            naveController.navigate(ADD_PRODUCTS_URL)
        }) {
           Text(text = "Products")
        }
        Button(onClick = {
            naveController.navigate(VIEW_PRODUCTS_URL)
        }) {
           Text(text = "About")
        }
        Button(onClick = {
            naveController.navigate(SIGNUP_URL)
        }) {
            Text(text = "signup")
        }
        Button(onClick = {
            naveController.navigate(LOGIN_URL)
        }) {
            Text(text = "login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WazitoEComerceTheme {
        HomeScreen(rememberNavController())
    }
}