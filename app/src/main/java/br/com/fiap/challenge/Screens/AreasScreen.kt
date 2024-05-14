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
fun AreasScreen() {
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

        SkillsAndCertificationsSection()

        InterestSection("Temas que você domina", "Dominate Themes")
        Spacer(modifier = Modifier.height(10.dp))
        InterestSection("Temas que você gostaria de dominar", "Aspire Themes")

        Spacer(modifier = Modifier.height(150.dp))
        ActionButtons()
    }
}

@Composable
fun SkillsAndCertificationsSection() {
    // Implementation remains similar to what has been defined before
}

@Composable
fun InterestSection(title: String, tag: String) {
    Text(
        title,
        fontSize = 16.sp,
        color = Color.Black,
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    )
    var interestText by remember { mutableStateOf("") }
    var interestsList by remember { mutableStateOf(listOf<String>()) }
    SkillEntryField(tag, interestText) { interestText = it }
    Button(
        onClick = {
            if (interestText.isNotBlank()) {
                interestsList = interestsList + interestText
                interestText = ""
            }
        },
        modifier = Modifier.padding(top = 8.dp)
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add")
    }
    interestsList.forEach { interest ->
        MiniCard(interest) { interestsList = interestsList - interest }
    }
}

@Composable
fun ActionButtons() {
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

