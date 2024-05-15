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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challenge.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoftScreen() {
    var softSkills by remember { mutableStateOf(TextFieldValue("")) }
    var hardSkills by remember { mutableStateOf(TextFieldValue("")) }
    var idioma by remember { mutableStateOf(TextFieldValue("")) }
    var nivelIdioma by remember { mutableStateOf("") }

    var softSkillsList by remember { mutableStateOf(listOf<String>()) }
    var hardSkillsList by remember { mutableStateOf(listOf<String>()) }
    var idiomasList by remember { mutableStateOf(listOf<Pair<String, String>>()) }

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
            text = "Quais são as suas habilidades e qualificações?",
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = softSkills,
            onValueChange = { softSkills = it },
            label = { Text("Soft skills") },
            placeholder = { Text("Comunicação, Trabalho em equipe, Negociação, Liderança...") },
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
                    if (softSkills.text.isNotBlank()) {
                        softSkillsList = softSkillsList + softSkills.text
                        softSkills = TextFieldValue("")
                    }
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Add")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        SkillMiniCards(skills = softSkillsList, onRemove = { skill ->
            softSkillsList = softSkillsList - skill
        })

        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = idioma,
            onValueChange = { idioma = it },
            label = { Text("Idioma") },
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
                    if (idioma.text.isNotBlank() && nivelIdioma.isNotBlank()) {
                        idiomasList = idiomasList + (idioma.text to nivelIdioma)
                        idioma = TextFieldValue("")
                        nivelIdioma = ""
                    }
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Add")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        DropdownMenuField(
            value = nivelIdioma,
            onValueChange = { nivelIdioma = it },
            label = { Text("Nível") },
            options = listOf("Básico", "Intermediário", "Avançado"),
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        IdiomaMiniCards(idiomas = idiomasList, onRemove = { idioma ->
            idiomasList = idiomasList - idioma
        })

        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = hardSkills,
            onValueChange = { hardSkills = it },
            label = { Text("Hard skills") },
            placeholder = { Text("Linguagem de programação, Gestão de Projetos, Design gráfico...") },
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
                    if (hardSkills.text.isNotBlank()) {
                        hardSkillsList = hardSkillsList + hardSkills.text
                        hardSkills = TextFieldValue("")
                    }
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "Add")
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        SkillMiniCards(skills = hardSkillsList, onRemove = { skill ->
            hardSkillsList = hardSkillsList - skill
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
                text = "Página 5/xx",
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
fun SkillMiniCards(skills: List<String>, onRemove: (String) -> Unit) {
    Column {
        skills.forEach { skill ->
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
                    Text(skill, fontSize = 16.sp)
                    IconButton(onClick = { onRemove(skill) }) {
                        Icon(painter = painterResource(id = R.drawable.ic_delete), contentDescription = "Remove")
                    }
                }
            }
        }
    }
}

@Composable
fun IdiomaMiniCards(idiomas: List<Pair<String, String>>, onRemove: (Pair<String, String>) -> Unit) {
    Column {
        idiomas.forEach { (idioma, nivel) ->
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
                    Text("$idioma - $nivel", fontSize = 16.sp)
                    IconButton(onClick = { onRemove(idioma to nivel) }) {
                        Icon(painter = painterResource(id = R.drawable.ic_delete), contentDescription = "Remove")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuCamp(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    options: List<String>,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = label,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            readOnly = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            )
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onValueChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
