package br.com.fiap.challenge.Screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.challenge.R
import br.com.fiap.challenge.data.StepsCardData
import br.com.fiap.challenge.navigation.Screen
import br.com.fiap.challenge.viewmodel.UserProfileViewModel

@Composable
fun CardSelectionScreen(navController: NavHostController, userProfileViewModel: UserProfileViewModel = viewModel()) {
    var selectedCard by remember { mutableStateOf<StepsCardData?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.steps_to_the_light),
                    contentDescription = "Steps to the Light Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            items(cards) { card ->
                StepsCard(
                    imageResId = card.imageResId,
                    title = card.title,
                    titleColor = card.titleColor,
                    description = card.description,
                    onClick = { selectedCard = card },
                    isSelected = selectedCard == card
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
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

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    if (selectedCard != null) {
                        userProfileViewModel.updateCartaSemana(selectedCard!!)
                        navController.navigate(Screen.Success.route)
                    }
                },
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

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Etapa 11/12",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(6.dp))

        Image(
            painter = painterResource(id = R.drawable.db1_logo),
            contentDescription = "DB1 Group Logo",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun StepsCard(imageResId: Int, title: String, titleColor: Color, description: String, onClick: () -> Unit, isSelected: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(if (isSelected) 2.dp else 0.dp, Color.Blue, RoundedCornerShape(8.dp))
            .padding(8.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = title,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = titleColor
            )
            Text(
                text = description,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

val cards = listOf(
    StepsCardData(
        imageResId = R.drawable.locus_of_control,
        title = "Locus of Control",
        titleColor = Color(0xFF0073E6),
        description = "Empoderamento | Compromisso | Responsabilidade e Autonomia"
    ),
    StepsCardData(
        imageResId = R.drawable.energy,
        title = "Energy",
        titleColor = Color(0xFFFFA000),
        description = "Intensidade | Resiliência | Curtir a jornada"
    ),
    StepsCardData(
        imageResId = R.drawable.be_fair,
        title = "Be Fair, Do Right, Don't Hide",
        titleColor = Color(0xFF0073E6),
        description = "Justiça | Transparência | Credibilidade e Confiança"
    ),
    StepsCardData(
        imageResId = R.drawable.do_awesome,
        title = "Do Awesome Things",
        titleColor = Color(0xFFD32F2F),
        description = "Entrega de Valor | Qualidade e Excelência"
    ),
    StepsCardData(
        imageResId = R.drawable.you_matter,
        title = "You Matter",
        titleColor = Color(0xFF0073E6),
        description = "Apreciação de Pessoas | Desenvolvimento Profissional e Humano"
    ),
    StepsCardData(
        imageResId = R.drawable.team_spirit,
        title = "Team Spirit",
        titleColor = Color(0xFFFFA000),
        description = "Trabalho orientado para missão | Camaradagem | Feedback honesto e constante"
    ),
    StepsCardData(
        imageResId = R.drawable.to_infinity,
        title = "To Infinity and Beyond",
        titleColor = Color(0xFF0073E6),
        description = "Evolução | Errar faz parte da jornada | Um desafio pode ser uma grande oportunidade"
    )
)
