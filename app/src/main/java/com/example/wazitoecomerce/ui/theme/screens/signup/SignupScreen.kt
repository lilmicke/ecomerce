package com.example.wazitoecomerce.ui.theme.screens.signup

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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecomerce.R
import com.example.wazitoecomerce.data.AuthViewModel
import com.example.wazitoecomerce.navigation.LOGIN_URL
import com.example.wazitoecomerce.ui.theme.WazitoEComerceTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(naveController: NavController){
    Text(modifier = Modifier
        , fontSize = 40.sp,
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold, text = "Sign up")
    Column(modifier = Modifier
        .padding(bottom = 50.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {

        Image(modifier = Modifier
            .height(250.dp)
            .padding(bottom = 50.dp), painter = painterResource(id = R.drawable.image), contentDescription ="my pic" )

        var name by remember {
            mutableStateOf("")}
        OutlinedTextField(value = name, onValueChange ={name=it},
            label = { Text(text = "Enter your name")},
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 30.dp),
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
        )
        Spacer(modifier = Modifier.height(5.dp))
        var email by remember {
            mutableStateOf("")}
        OutlinedTextField(value = email, onValueChange ={email=it},
            label = { Text(text = "Enter your email")},
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(top = 30.dp),
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next)
        )
        Spacer(modifier = Modifier.height(5.dp))
        var password by remember {
            mutableStateOf("")}
        OutlinedTextField(value = password, onValueChange ={password=it},
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
        Spacer(modifier = Modifier.height(10.dp))
        val context= LocalContext.current
        val authViewModel=AuthViewModel(naveController,context)
        Button(modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 30.dp),
            shape = RoundedCornerShape(20.dp),onClick = { authViewModel.signup(name,email, password) }) {
            Text(text = "Register")
        }
        Button(modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(top = 30.dp),
            shape = RoundedCornerShape(20.dp),
            onClick = { naveController.navigate(LOGIN_URL) }) {
            Text(text = "sign up")
        }


    }

}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview(){
    WazitoEComerceTheme  {
        SignupScreen(rememberNavController())
    }
}