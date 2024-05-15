package br.com.fiap.challenge.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun SkillsScreen() {
    var temaDomina by remember { mutableStateOf(TextFieldValue("")) }
    var temaGostaria by remember { mutableStateOf(TextFieldValue("")) }

    var temasDominaList by remember { mutableStateOf(listOf<String>()) }
    var temasGostariaList by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.mentorsphere_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "E as suas áreas de interesse?",
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = temaDomina,
            onValueChange = { temaDomina = it },
            label = { Text("Temas que você domina") },
            placeholder = { Text("Futebol, Política, Educação, Python, SQL, NoSQL...") },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            ),
            trailingIcon = {
                IconButton(onClick = {
                    if (temaDomina.text.isNotBlank()) {
                        temasDominaList = temasDominaList + temaDomina.text
                        temaDomina = TextFieldValue("")
                    }
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Add")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        MiniCards(items = temasDominaList, onRemove = { item ->
            temasDominaList = temasDominaList - item
        })

        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = temaGostaria,
            onValueChange = { temaGostaria = it },
            label = { Text("Temas que você gostaria de dominar") },
            placeholder = { Text("Economia, Mercado de trabalho, Gastronomia, Java, Javascript...") },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            ),
            trailingIcon = {
                IconButton(onClick = {
                    if (temaGostaria.text.isNotBlank()) {
                        temasGostariaList = temasGostariaList + temaGostaria.text
                        temaGostaria = TextFieldValue("")
                    }
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Add")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        MiniCards(items = temasGostariaList, onRemove = { item ->
            temasGostariaList = temasGostariaList - item
        })

        Spacer(modifier = Modifier.height(32.dp))
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
                text = "Página 7/xx",
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

@Composable
fun MiniCards(items: List<String>, onRemove: (String) -> Unit) {
    Column {
        items.forEach { item ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(vertical = 4.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(item, fontSize = 16.sp)
                    IconButton(onClick = { onRemove(item) }) {
                        Icon(painter = painterResource(id = R.drawable.ic_delete), contentDescription = "Remove")
                    }
                }
            }
        }
    }
}
