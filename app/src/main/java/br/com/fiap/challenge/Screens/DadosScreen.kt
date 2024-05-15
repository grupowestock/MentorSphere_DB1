package br.com.fiap.challenge.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DadosScreen() {
    var nomeCompleto by remember { mutableStateOf(TextFieldValue("")) }
    var dataNascimento by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var celular by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.mentorsphere_logo),
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Vamos começar com seus dados pessoais:",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 24.dp),
                textAlign = TextAlign.Center
            )
            OutlinedTextField(
                value = nomeCompleto,
                onValueChange = { nomeCompleto = it },
                label = { Text("Nome completo") },
                placeholder = { Text("Digite seu nome") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = dataNascimento,
                onValueChange = { dataNascimento = it },
                label = { Text("Data de nascimento") },
                placeholder = { Text("xx/xx/xxxx") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail") },
                placeholder = { Text("Digite seu e-mail") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = celular,
                onValueChange = { celular = it },
                label = { Text("Celular") },
                placeholder = { Text("+xx (xx) xxxxx-xxxx") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(32.dp)) // Aumentamos o espaçamento aqui
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                    Text("Salvar e Voltar depois", color = Color.Black, fontSize = 16.sp)
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
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Página 1/xx",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.db1_logo),
                contentDescription = "DB1 Logo",
                modifier = Modifier.size(64.dp)
            )
        }
    }
}
