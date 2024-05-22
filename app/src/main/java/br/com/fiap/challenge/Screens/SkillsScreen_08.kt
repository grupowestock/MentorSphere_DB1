package br.com.fiap.challenge.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.challenge.R
import br.com.fiap.challenge.navigation.Screen
import br.com.fiap.challenge.viewmodel.UserProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkillsScreen(navController: NavHostController, userProfileViewModel: UserProfileViewModel = viewModel()) {
    var temaDomina by remember { mutableStateOf(TextFieldValue("")) }
    var temaGostaria by remember { mutableStateOf(TextFieldValue("")) }

    val userProfile by userProfileViewModel.userProfile.observeAsState()

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
            modifier = Modifier.size(160.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Quais temas você domina e quais gostaria de aprender?",
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = temaDomina,
            onValueChange = {
                temaDomina = it
                userProfileViewModel.updateMentorThemes(it.text)
            },
            label = { Text("Temas que você domina") },
            placeholder = { Text("Digite aqui") },
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
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add"
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TemaMiniCards(temas = temasDominaList, onRemove = { tema ->
            temasDominaList = temasDominaList - tema
        })

        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = temaGostaria,
            onValueChange = {
                temaGostaria = it
                userProfileViewModel.updateApprenticeThemes(it.text)
            },
            label = { Text("Temas que gostaria de aprender") },
            placeholder = { Text("Digite aqui") },
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
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "Add"
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TemaMiniCards(temas = temasGostariaList, onRemove = { tema ->
            temasGostariaList = temasGostariaList - tema
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
                    onClick = { navController.popBackStack() },
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(54.dp)
                        .padding(end = 8.dp)
                        .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Voltar", color = Color.Black, fontSize = 16.sp)
                }
                Button(
                    onClick = { navController.navigate(Screen.You.route) },
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .weight(1f)
                        .height(54.dp)
                        .padding(start = 8.dp)
                        .border(2.dp, Color.Blue, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Salvar e Continuar", color = Color.Blue, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Etapa 6/12",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.db1_logo),
                contentDescription = "DB1 Logo",
                modifier = Modifier.size(100.dp)
            )
        }
    }

}

@Composable
fun TemaMiniCards(temas: List<String>, onRemove: (String) -> Unit) {
    Column {
        temas.forEach { tema ->
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
                    Text(tema, fontSize = 16.sp)
                    IconButton(onClick = { onRemove(tema) }) {
                        Icon(painter = painterResource(id = R.drawable.ic_delete), contentDescription = "Remove")
                    }
                }
            }
        }
    }
}
