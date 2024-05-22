package br.com.fiap.challenge.Screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.challenge.R

@Composable
fun SearchScreen(navController: NavHostController) {
    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Search bar, filters and items
            LazyColumn(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.voltar),
                            contentDescription = "Voltar",
                            modifier = Modifier
                                .size(24.dp)
                                .clickable { navController.popBackStack() }
                        )
                        Text(
                            text = "BUSCA",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_marcos),
                            contentDescription = "Profile Image",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    // Mentor and Apprentice checkboxes, search bar, and advanced search link
                    Row {
                        // Your checkbox and search bar implementation
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

                items(cardsSearch) { card ->
                    SearchResultCard(
                        imageResId = card.imageResId,
                        name = card.name,
                        title = card.title,
                        location = card.location
                    )
                }
            }
        }
    }
}

@Composable
fun SearchResultCard(imageResId: Int, name: String, title: String, location: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = name,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title,
                fontSize = 16.sp
            )
            Text(
                text = location,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}

data class SearchResultCardData(
    val imageResId: Int,
    val name: String,
    val title: String,
    val location: String
)

val cardsSearch = listOf(
    // Sample data
    SearchResultCardData(
        imageResId = R.drawable.photo_ada,
        name = "Ada Keller",
        title = "Tech Lead em Tinbot",
        location = "São Paulo | Brasil"
    ),
    SearchResultCardData(
        imageResId = R.drawable.photo_bruna,
        name = "Bruna Moraes",
        title = "Desenvolvedora Java Sênior em DB1 Global",
        location = "Maringá | Brasil"
    ),
    SearchResultCardData(
        imageResId = R.drawable.photo_joao,
        name = "João Pereira",
        title = "Desenvolvedor Python Sênior em DB1 Global",
        location = "Fortaleza | Brasil"
    ),
    SearchResultCardData(
        imageResId = R.drawable.photo_helena,
        name = "Helena Costa",
        title = "Consultora Comercial Pleno em Mixtra",
        location = "Fortaleza | Brasil"
    )
)
