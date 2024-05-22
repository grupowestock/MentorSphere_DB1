package br.com.fiap.challenge.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun ProfileScreenRead(navController: NavHostController) {
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
                    Button(
                        onClick = { /* Handle Solicitar Mentoria */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        border = BorderStroke(1.dp, Color.Blue),
                    ) {
                        Text("Solicitar \nmentoria", fontSize = 16.sp, color = Color.Blue)
                    }
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
                            painter = painterResource(id = R.drawable.profile_picture),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(140.dp)
                            //.padding(8.dp)
                        )
                    }

                    Column {
                        Text(
                            text = "Ada Keller",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Tech Lead em",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Image(
                            painter = painterResource(id = R.drawable.tinbot_logo),
                            contentDescription = "Tinbot Logo",
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "ada.keller@tinbot.com.br",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Text(
                            text = "São Paulo | Brasil",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Text(
                            text = "20 mentorados | 3 mentores",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Carta da semana:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.do_awesome),
                    contentDescription = "Carta da Semana",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Sobre",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Mais de 5 anos de experiência em inovações tecnológicas, liderança de equipes multidisciplinares e colaboração. Habilidades técnicas e de liderança para desenhar arquiteturas robustas, processos eficientes e entregar produtos de qualidade. Comprometido em ficar à frente das tendências da indústria e orientar membros da equipe, estou ansioso para me conectar e explorar oportunidades que aproveitem minha paixão pela tecnologia e liderança.",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Posso dar mentoria em:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = """
                        • Java
                        • Python
                        • Agile
                        • Scrum
                        • Software Design Patterns
                        • Frameworks, Spring, Hibernate, Angular e React
                        • Bancos de Dados e SQL
                        • Git
                        • Serviços em Cloud
                        • Liderança e Gestão
                    """.trimIndent(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Quero aprender:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = """
                        • Liderança Executiva
                        • Tecnologias Emergentes (Blockchain, Inteligência Artificial)
                        • Empreendedorismo e Inovação
                        • Gestão Avançada de Projetos
                    """.trimIndent(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Áreas de interesse",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = """
                        • Inteligência Artificial
                        • Machine Learning
                        • Serviços em Cloud
                        • DevOps
                        • Cybersecurity
                        • UI/UX
                    """.trimIndent(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Soft skills",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = """
                        • Liderança e Gerenciamento de Equipes
                        • Comunicação (Verbal e Escrita)
                        • Resolução de Problemas
                        • Pensamento Estratégico
                        • Adaptabilidade
                        • Colaboração e Trabalho em Equipe
                    """.trimIndent(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Hard skills",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = """
                        • Java
                        • JavaScript
                        • Python
                        • Agile
                        • Scrum
                        • Estruturas de Dados e Algoritmos
                        • Princípios de Engenharia de Software
                        • Gestão de Banco de Dados
                        • Finanças, Marketing, Estratégia
                        • Habilidades de Pesquisa
                    """.trimIndent(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Formação Acadêmica",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Bacharelado em Ciência da Computação | Mestrado em Administração de Empresas | Doutorado em Ciência da Computação",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Disponibilidade",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.calendar_ada),
                    contentDescription = "Agenda Ada",
                    modifier = Modifier
                        .size(300.dp)
                )

                Text(
                    text = "Horários disponíveis     Horários ocupados",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Text(
                    text = "07/06/2024\n das 10h às 11h",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}