package br.com.fiap.challenge.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExperienceScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "E a sua experiência profissional:",
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        ExperienceCard()
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Adicionar mais um (+)",
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle add more experience details */ }
        )
        Spacer(modifier = Modifier.height(42.dp))
        AcaoButtons()
    }
}

@Composable
fun ExperienceCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(2.dp, Color.Black, RoundedCornerShape(30.dp))
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            ExperienceTextField("Nome da empresa/Divisão")
            ExperienceTextField("Área de atuação/Departamento")
            ExperienceTextField("Cargo")
            PeriodField("Período de atuação")
            ExperienceTextField("Responsabilidades")
            ExperienceTextField("Conquistas")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExperienceTextField(label: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(label, color = Color.Black, fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 6.dp))
        TextField(
            value = "",
            onValueChange = {},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                .background(Color.White),
            colors = TextFieldDefaults.textFieldColors(cursorColor = Color.Black),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeriodField(label: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(label, color = Color.Black, fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 6.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .height(30.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .background(Color.White),
                colors = TextFieldDefaults.textFieldColors(cursorColor = Color.Black),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = "",
                onValueChange = {},
                singleLine = true,
                modifier = Modifier
                    .weight(1f)
                    .height(30.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                    .background(Color.White),
                colors = TextFieldDefaults.textFieldColors(cursorColor = Color.Black),
                shape = RoundedCornerShape(8.dp)
            )
        }
    }
}
