package br.com.fiap.challenge.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.challenge.R
import br.com.fiap.challenge.navigation.Screen

@Composable
fun SearchAdvancedScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopBarAdvanced(navController) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Form fields for advanced search
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var name by remember { mutableStateOf(TextFieldValue("")) }
                var email by remember { mutableStateOf(TextFieldValue("")) }
                var location by remember { mutableStateOf(TextFieldValue("")) }
                var educationLevel by remember { mutableStateOf(TextFieldValue("")) }
                var professionalExperience by remember { mutableStateOf(TextFieldValue("")) }
                var skills by remember { mutableStateOf(TextFieldValue("")) }
                var language by remember { mutableStateOf(TextFieldValue("")) }
                var certificates by remember { mutableStateOf(TextFieldValue("")) }
                var interestAreas by remember { mutableStateOf(TextFieldValue("")) }
                var selectedMentor by remember { mutableStateOf(false) }
                var selectedApprentice by remember { mutableStateOf(false) }

                // Checkboxes para Mentor(a) e Aprendiz
                Row {
                    Checkbox(
                        checked = selectedMentor,
                        onCheckedChange = { selectedMentor = it }
                    )
                    Text(text = "Mentor")
                    Spacer(modifier = Modifier.width(16.dp))
                    Checkbox(
                        checked = selectedApprentice,
                        onCheckedChange = { selectedApprentice = it }
                    )
                    Text(text = "Aprendiz")
                }
                Spacer(modifier = Modifier.height(8.dp))

                // Campo Nome
                StyledTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = "Nome"
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo E-mail
                StyledTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = "E-mail"
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo Endereço
                StyledTextField(
                    value = location,
                    onValueChange = { location = it },
                    label = "Endereço (País ou Cidade)"
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo Estudos
                StyledTextField(
                    value = educationLevel,
                    onValueChange = { educationLevel = it },
                    label = "Formação Acadêmica"
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo Experiência Profissional
                StyledTextField(
                    value = professionalExperience,
                    onValueChange = { professionalExperience = it },
                    label = "Experiência Profissional"
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo Skills
                StyledTextField(
                    value = skills,
                    onValueChange = { skills = it },
                    label = "Skills"
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo Idiomas
                StyledTextField(
                    value = language,
                    onValueChange = { language = it },
                    label = "Idiomas"
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo Certificação
                StyledTextField(
                    value = certificates,
                    onValueChange = { certificates = it },
                    label = "Certificações"
                )
                Spacer(modifier = Modifier.height(8.dp))

                // Campo Áreas de Interesse
                StyledTextField(
                    value = interestAreas,
                    onValueChange = { interestAreas = it },
                    label = "Áreas de interesse"
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { navController.navigate(Screen.SearchScreen.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Aplicar Filtros",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_lupa),
                        contentDescription = "Search",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TopBarAdvanced(navController: NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.voltar),
            contentDescription = "Voltar",
            modifier = Modifier
                .size(70.dp)
                .clickable { navController.popBackStack() }
        )
        Text(
            text = "BUSCA \nAVANÇADA",
            fontSize = 24.sp,
            color = Color(0xFF00A86B),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.ic_marcos),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(60.dp)
                .border(2.dp, Color.Gray, CircleShape)
        )
    }
}

@Composable
fun StyledTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(8.dp)
                .background(Color(0xFFF0F0F0))
        )
    }
}
