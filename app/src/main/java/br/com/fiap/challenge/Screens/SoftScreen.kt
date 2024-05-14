package br.com.fiap.challenge.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.challenge.Components.Certifications
import br.com.fiap.challenge.Components.LanguageSkills

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoftScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Quais são as suas habilidades e qualificações?",
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Soft Skills
        var softSkillText by remember { mutableStateOf("") }
        var softSkillsList by remember { mutableStateOf(listOf<String>()) }
        SkillEntryField("Soft Skills", softSkillText) { softSkillText = it }

        Button(
            onClick = {
                if (softSkillText.isNotBlank()) {
                    softSkillsList = softSkillsList + softSkillText
                    softSkillText = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
        softSkillsList.forEach { skill ->
            MiniCard(skill) { softSkillsList = softSkillsList - skill }
        }
        Spacer(modifier = Modifier.height(10.dp))
        // Languages
        LanguageSkills()

        Spacer(modifier = Modifier.height(20.dp))

        // Hard Skills
        var hardSkillText by remember { mutableStateOf("") }
        var hardSkillsList by remember { mutableStateOf(listOf<String>()) }
        SkillEntryField("Hard Skill", hardSkillText) { hardSkillText = it }
        Button(
            onClick = {
                if (hardSkillText.isNotBlank()) {
                    hardSkillsList = hardSkillsList + hardSkillText
                    hardSkillText = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
        hardSkillsList.forEach { skill ->
            MiniCard(skill) { hardSkillsList = hardSkillsList - skill }
        }
        Spacer(modifier = Modifier.height(10.dp))
        // Certifications
        Certifications()

        Spacer(modifier = Modifier.height(20.dp))
        AcaoButtons()
    }
}

@Composable
fun SkillEntryField(label: String, text: String, onTextChange: (String) -> Unit) {
    Column {
        TextField(
            value = text,
            onValueChange = onTextChange,
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun MiniCard(skill: String, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(skill, modifier = Modifier.weight(1f))
            IconButton(onClick = onDelete) {
                Icon(Icons.Filled.Close, contentDescription = "Delete")
            }
        }
    }
}

// Implementação similar para LanguageSkills e Certifications

@Composable
fun AcaoButtons() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { /* Handle Save and Return Later */ },
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .weight(1f)
                .height(56.dp)
                .padding(end = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Salvar e voltar depois", color = Color.Black, fontSize = 14.sp)
        }
        Button(
            onClick = { /* Handle Save and Continue */ },
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .weight(1f)
                .height(56.dp)
                .padding(start = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Salvar e continuar", color = Color.Black, fontSize = 14.sp)
        }
    }
}

