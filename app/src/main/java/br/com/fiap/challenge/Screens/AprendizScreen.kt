package br.com.fiap.challenge.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.challenge.viewmodel.UserProfileViewModel

@Composable
fun AprendizScreen(navController: NavHostController, userProfileViewModel: UserProfileViewModel = viewModel()) {
    var aprendiz by remember { mutableStateOf(TextFieldValue("")) }
    val userProfile by userProfileViewModel.userProfile.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = aprendiz,
            onValueChange = {
                aprendiz = it
                userProfileViewModel.updateApprenticeThemes(it.text) },

            label = { Text("Temas para aprender")}
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Temas para aprender: ${userProfile?.temasAprendiz ?: ""}")
    }
}


