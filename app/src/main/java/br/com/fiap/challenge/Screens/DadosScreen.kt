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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DadosScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Vamos começar com seus dados pessoais:",
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(38.dp))
        HeaderTextField("Nome Completo", "Digite o seu nome")
        HeaderTextField("Data de nascimento", "xx/xx/xxxx")
        HeaderTextField("E-mail", "example@email.com")
        HeaderTextField("Celular", "+xx (xx) xxxxx-xxxx")
        Spacer(modifier = Modifier.height(52.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* Handle Save and Return Later */ },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(54.dp)
                    .padding(end = 8.dp)
                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Salvar e voltar depois", color = Color.Black, fontSize = 16.sp)
            }
            Button(
                onClick = { /* Handle Save and Continue */ },
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(54.dp)
                    .padding(start = 8.dp)
                    .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Salvar e Continuar", color = Color.Black, fontSize = 16.sp)

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderTextField(header: String, placeholder: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(header, color = Color.Black, fontSize = 16.sp, modifier = Modifier.padding(bottom = 8.dp))
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = placeholder, color = Color.Gray, fontSize = 12.sp) },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(8.dp))
                .background(Color.White),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black
            ),
            shape = RoundedCornerShape(25.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}
