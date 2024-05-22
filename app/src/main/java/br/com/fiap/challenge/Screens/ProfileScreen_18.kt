package br.com.fiap.challenge.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.challenge.R
import br.com.fiap.challenge.navigation.Screen

@Composable
fun ProfileScreen(navController: NavHostController) {
    val (isEditing, setEditing) = remember { mutableStateOf(false) }
    val (name, setName) = remember { mutableStateOf("Marcos Souza") }
    val (about, setAbout) = remember { mutableStateOf("Desenvolvedor Java Júnior com habilidades em Java, SQL, Spring e mais.\nÁvido por aprender, trabalhar em equipe e resolver problemas.\nBuscando oportunidades para crescer profissionalmente sob mentoria.") }
    val (learningGoals, setLearningGoals) = remember { mutableStateOf("""
                        • Java Avançado (JVM, melhora de performance)
                        • Arquitetura de Software
                        • Frameworks: Angular, React, Vue.js
                        • RESTful APIs
                        • Serviços em Cloud
                        • Melhores práticas de Desenvolvimento Web
                        • Otimização de Bancos de Dados
                        • Liderança e Trabalho em Equipe
                    """.trimIndent()) }
    val (interests, setInterests) = remember { mutableStateOf("""
                        • JEE, JSF e JPA
                        • Java-based web development
                        • Android Development
                        • Serviços em Cloud
                        • Machine Learning
                    """.trimIndent()) }
    val (softSkills, setSoftSkills) = remember { mutableStateOf("""
                        • Comunicação (Verbal e Escrita)
                        • Resolução de Problemas
                        • Gestão de Tempo
                        • Adaptabilidade
                        • Colaboração e Trabalho em Equipe
                        • Atenção aos detalhes
                    """.trimIndent()) }
    val (hardSkills, setHardSkills) = remember { mutableStateOf("""
                        • Java
                        • JavaScript
                        • C++
                        • Python
                        • Spring
                        • MySQL
                        • IntelliJ IDEA
                        • Gradle
                        • Git
                    """.trimIndent()) }
    val (education, setEducation) = remember { mutableStateOf("Bacharelado em Ciência da Computação") }
    val (availability, setAvailability) = remember { mutableStateOf("07/06/2024\n das 10h às 11h") }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.navigate(Screen.Dashboard.route) }) {
                        Image(
                            painter = painterResource(id = R.drawable.voltar),
                            contentDescription = "Voltar",
                            modifier = Modifier.size(200.dp)
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.mentorsphere_logo),
                        contentDescription = "MentorSphere Logo",
                        modifier = Modifier
                            .size(100.dp)
                            .height(100.dp)
                            .padding(bottom = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.photo_marcos),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(140.dp)
                        )
                        Button(
                            onClick = { /* Handle Update Photo */ },
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            border = BorderStroke(1.dp, Color.Black)
                        ) {
                            Text("Atualizar foto", fontSize = 12.sp, color = Color.Black)
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (isEditing) {
                                TextField(
                                    value = name,
                                    onValueChange = setName,
                                    modifier = Modifier.weight(1f)
                                )
                            } else {
                                Text(
                                    text = name,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            Image(
                                painter = painterResource(id = R.drawable.ic_editar),
                                contentDescription = "Editar Nome",
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable { setEditing(!isEditing) }
                            )
                        }
                        Text(
                            text = "Desenvolvedor Júnior em",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Image(
                            painter = painterResource(id = R.drawable.logo_anymarket),
                            contentDescription = "Logo AnyMarket",
                            modifier = Modifier.size(70.dp)
                        )
                        Text(
                            text = "marcos.souza@anymarket.com.br",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Text(
                            text = "Maringá | Brasil",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Text(
                            text = "1 mentora",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Carta da semana:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_editar),
                        contentDescription = "Editar Carta da Semana",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { setEditing(!isEditing) }
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.energy),
                    contentDescription = "Carta da Semana",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                EditableSection(
                    title = "Sobre",
                    text = about,
                    onTextChange = setAbout,
                    isEditing = isEditing,
                    setEditing = setEditing
                )

                EditableSection(
                    title = "Quero aprender:",
                    text = learningGoals,
                    onTextChange = setLearningGoals,
                    isEditing = isEditing,
                    setEditing = setEditing
                )

                EditableSection(
                    title = "Áreas de interesse",
                    text = interests,
                    onTextChange = setInterests,
                    isEditing = isEditing,
                    setEditing = setEditing
                )

                EditableSection(
                    title = "Soft skills",
                    text = softSkills,
                    onTextChange = setSoftSkills,
                    isEditing = isEditing,
                    setEditing = setEditing
                )

                EditableSection(
                    title = "Hard skills",
                    text = hardSkills,
                    onTextChange = setHardSkills,
                    isEditing = isEditing,
                    setEditing = setEditing
                )

                EditableSection(
                    title = "Formação Acadêmica",
                    text = education,
                    onTextChange = setEducation,
                    isEditing = isEditing,
                    setEditing = setEditing
                )

                EditableSection(
                    title = "Disponibilidade",
                    text = availability,
                    onTextChange = setAvailability,
                    isEditing = isEditing,
                    setEditing = setEditing
                )

                Image(
                    painter = painterResource(id = R.drawable.calendar_marcos),
                    contentDescription = "Agenda Marcos",
                    modifier = Modifier
                        .size(300.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Horário disponível",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = availability,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun EditableSection(
    title: String,
    text: String,
    onTextChange: (String) -> Unit,
    isEditing: Boolean,
    setEditing: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isEditing) {
            TextField(
                value = text,
                onValueChange = onTextChange,
                modifier = Modifier.weight(1f)
            )
        } else {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_editar),
            contentDescription = "Editar $title",
            modifier = Modifier
                .size(24.dp)
                .clickable { setEditing(!isEditing) }
        )
    }
    if (isEditing) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
    } else {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}
