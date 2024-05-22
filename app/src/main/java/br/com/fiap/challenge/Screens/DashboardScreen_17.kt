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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
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
fun DashboardScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopBar(navController) },
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Busca de mentores/aprendizes", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Checkbox(checked = false, onCheckedChange = {})
                Text(text = "Mentor", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Checkbox(checked = false, onCheckedChange = {})
                Text(text = "Aprendiz", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(1.dp, Color(0xFF6A1B9A), RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {
                BasicTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.weight(1f)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_lupa),
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp)
                )
            }
            Text(
                text = "Busca Avançada",
                color = Color(0xFF6A1B9A),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable { navController.navigate(Screen.SearchAdvancedScreen.route) }
                    .align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Novos matches", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            MatchCard(navController)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Sua Carta da Semana", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            WeekCard()
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Sua Agenda", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            AgendaSection()
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun TopBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.mentorsphere_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = "HOME",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF00A86B)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_marcos),
            contentDescription = "Profile",
            modifier = Modifier
                .size(60.dp)
                .border(2.dp, Color.Gray, CircleShape)
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun MatchCard(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(1.dp, Color(0xFF6A1B9A), RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo_ada),
            contentDescription = "Profile",
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Ada Keller", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = "Tech Lead em Tinbot", fontSize = 14.sp, color = Color.Gray)
            Text(text = "São Paulo | Brasil", fontSize = 14.sp, color = Color.Gray)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Ver Perfil",
                    color = Color(0xFF6A1B9A),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable { navController.navigate(Screen.ProfileRead.route) }
                )
                Text(
                    text = "Solicitar mentoria",
                    color = Color(0xFF00A86B),
                    modifier = Modifier
                        .padding(start = 8.dp)
                    //.clickable { /* Request mentorship */ }
                )
            }
        }
    }
}

@Composable
fun WeekCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(1.dp, Color(0xFF6A1B9A), RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.energy),
            contentDescription = "Card Image",
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Energy", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFFF57C00))
            Text(text = "Intensidade | Resiliência | Curtir a jornada", fontSize = 14.sp, color = Color.Gray)
            Text(
                text = "Editar",
                color = Color(0xFF6A1B9A),
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable { /*navController.navigate(Screen.CardSelection.route)*/ }
                    .align(Alignment.End)
            )
        }
    }
}

@Composable
fun AgendaSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.calendar_marcos),
            contentDescription = "Calendar",
            modifier = Modifier.size(120.dp)
        )
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Próxima sessão", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Text(text = "06/06/2024 - 10h", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Mentora", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Bruna Moraes", fontSize = 14.sp, color = Color.Gray)
        }
    }
}





////////////////////////////////////////////////////////////////////////
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp)
    ) {
        IconButton(onClick = { navController.navigate(Screen.SearchScreen.route) }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.busca),
                    contentDescription = "Search",
                    modifier = Modifier.size(40.dp)
                )
                //Text(text = "Busca", fontSize = 12.sp, color = Color.Black)
            }
        }
        IconButton(onClick = { navController.navigate(Screen.MatchesScreen.route) }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.favoritos),
                    contentDescription = "Matches",
                    modifier = Modifier.size(40.dp)
                )
                //Text(text = "Matches", fontSize = 12.sp, color = Color.Black)
            }
        }
        IconButton(onClick = { navController.navigate(Screen.Dashboard.route) }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier.size(40.dp)
                )
                //Text(text = "Home", fontSize = 12.sp, color = Color.Black)
            }
        }
        IconButton(onClick = { /*navController.navigate(Screen.Schedule.route)*/ }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.agenda),
                    contentDescription = "Schedule",
                    modifier = Modifier.size(35.dp)
                )
                //Text(text = "Agenda", fontSize = 12.sp, color = Color.Black)
            }
        }
        IconButton(onClick = { navController.navigate(Screen.Profile.route) }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.perfil),
                    contentDescription = "Profile",
                    modifier = Modifier.size(40.dp)
                )
                //Text(text = "Perfil", fontSize = 12.sp, color = Color.Black)
            }
        }
    }
}
