package br.com.fiap.challenge.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var functionalCode by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            value = functionalCode,
            onValueChange = { functionalCode = it },
            label = "Codigo Funcional",
            imeAction = ImeAction.Next
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Senha",
            imeAction = ImeAction.Done,
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /* Handle the login logic here */ },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(100.dp)
                .height(38.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(15.dp))  // Added border
                .background(Color.White),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Entrar", color = Color.Black, fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(120.dp))
        Text(
            "Esqueceu sua senha?",
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.clickable(onClick = { /* Handle forgot password */ })
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(value: String, onValueChange: (String) -> Unit, label: String, imeAction: ImeAction, visualTransformation: VisualTransformation = VisualTransformation.None) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        visualTransformation = visualTransformation,
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Black, RoundedCornerShape(15.dp))
            .background(Color.White),
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.Black,

        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = imeAction),
        shape = RoundedCornerShape(25.dp),
        label = {
            Box(contentAlignment = Alignment.Center) {
                Text(text = label, color = Color.Black,)
            }
        }
    )
}