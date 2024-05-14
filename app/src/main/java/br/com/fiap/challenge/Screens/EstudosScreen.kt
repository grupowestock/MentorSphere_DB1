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
fun EstudoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Me conte sobre seus estudos:",
            color = Color.Black,
            fontSize = 20.sp,  // Reduced font size
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))  // Reduced spacer height
        EducationCard()
        Spacer(modifier = Modifier.height(20.dp))  // Reduced spacer height
        Text(
            "Adicionar mais um (+)",
            color = Color.Black,
            fontSize = 14.sp,  // Reduced font size
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle add more education details */ }
        )
        Spacer(modifier = Modifier.height(42.dp))  // Reduced spacer height
        AcaoSaveButtons()
    }
}

@Composable
fun EducationCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)  // Reduced padding for the card
            .border(2.dp, Color.Black, RoundedCornerShape(30.dp))
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            EducationTextField("Grau de escolaridade")
            EducationTextField("Área de estudo")
            EducationTextField("Nome da instituição")
            EducationTextField("Nome do curso")
            EducationTextField("Duração")
            EducationTextField("Data de conclusão")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EducationTextField(label: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(label, color = Color.Black, fontSize = 12.sp,  // Reduced font size
            modifier = Modifier.padding(bottom = 6.dp))
        TextField(
            value = "",
            onValueChange = {},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)  // Reduced height of TextField
                .border(1.dp, Color.Black, RoundedCornerShape(8.dp))  // Reduced border thickness
                .background(Color.White),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black

            ),
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))  // Maintain this spacer
    }
}

@Composable
fun AcaoSaveButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { /* Handle Save and Return Later */ },
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .weight(1f)
                .height(56.dp)  // Reduced button height
                .padding(end = 8.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Salvar e voltar depois", color = Color.Black, fontSize = 14.sp)  // Reduced font size
        }
        Button(
            onClick = { /* Handle Save and Continue */ },
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .weight(1f)
                .height(56.dp)  // Reduced button height
                .padding(start = 8.dp)
                .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Salvar e continuar", color = Color.Black, fontSize = 14.sp)  // Reduced font size
        }
    }
}
