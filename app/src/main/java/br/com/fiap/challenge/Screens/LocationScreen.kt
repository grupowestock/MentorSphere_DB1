package br.com.fiap.challenge.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Onde você mora?",
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(38.dp))
        CabecalhoText("País", "Selecione o seu país")
        CabecalhoText("Estado", "Selecione o seu estado")
        CabecalhoText("Cidade", "Digite sua cidade")
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
fun CabecalhoText(header: String, placeholder: String) {
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
