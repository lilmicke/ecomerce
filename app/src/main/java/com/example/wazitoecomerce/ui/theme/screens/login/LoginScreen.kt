package com.example.wazitoecomerce.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import androidx.navigation.compose.rememberNavController
import com.example.wazitoecomerce.R
import com.example.wazitoecomerce.data.AuthViewModel
import com.example.wazitoecomerce.navigation.SIGNUP_URL
import com.example.wazitoecomerce.ui.theme.WazitoEComerceTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(naveController: NavHostController) {

    Text(
        modifier = Modifier.padding(10.dp), fontSize = 40.sp,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold, text = "login"
    )

    Column(
        modifier = Modifier
            .padding(bottom = 50.dp)
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom
    ) {


        Image(modifier = Modifier
            .height(250.dp)
            .padding(bottom = 50.dp), painter = painterResource(id = R.drawable.image), contentDescription ="my pic" )

        var email by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Enter your email") },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 30.dp),
            shape = RoundedCornerShape(20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        var password by remember {
            mutableStateOf("")
        }
        OutlinedTextField(value = password, onValueChange = { password = it },
            label = { Text(text = "Enter your password")},
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 30.dp),
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
        )
        val context = LocalContext.current
        var authViewModel=AuthViewModel(naveController,context)
        Button(modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 30.dp),
            shape = RoundedCornerShape(20.dp),onClick = { authViewModel.login(email,password) }) {
            Text(text = "login")
            Button(onClick = { naveController.navigate(SIGNUP_URL) }) {
               Text(text = "Sign up ") 
            }

        }


    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    WazitoEComerceTheme {
        LoginScreen(rememberNavController())
    }
}